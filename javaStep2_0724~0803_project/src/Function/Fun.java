package Function;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

import DB.DAO;
import DB.EstockDTO;
import Server.SendClient;

public class Fun extends Thread {

	private int timecnt = 0;
	private int cnt = 0;
	private int cnt1 = 0;

	private int C1 = 10;
	private int C11 = C1;
	private int CT = C1 + 1 + C1;

	private int[][] chart = new int[CT][500];
	private String stockN;
	private ArrayList<PriceO> tc = new ArrayList<>();
	private Random r = new Random();
	private int center = 0;
	private int center1 = 0;
	private int centerN = 0;
	private int C2 = 0;

	private DAO dao;
	private ArrayList<String> totalID = new ArrayList<>();
	private ArrayList<String> broker;
	private ArrayList<Socket> socketT = new ArrayList<>();
	private ArrayList<SendClient> scT = new ArrayList<>();
	private ArrayList<SendClient> scB = new ArrayList<>();
	private ArrayList<SendClient> scTT = new ArrayList<>();

	public void setscTT(SendClient sc) {
		scTT.add(sc);
		goinfo();
	}

	public int centerP() {
		int price = tc.get(centerN).getPrice();
		return price;
	}

	public ArrayList<SendClient> getScT() {
		return scT;
	}

	public int getCenterN() {
		return centerN;
	}

	public ArrayList<String> getBroker() {
		return broker;
	}

	public String getStockN() {
		return stockN;
	}

	@Override
	public void run() {
		setP();
	}

	Fun(String stockN) {
		this.stockN = stockN;
		dao = DAO.getInstence();
		System.out.println(stockN);
	}

	public void setP() {
		center = dao.serchE(stockN);
		if (center < 1000) {
			cnt = 1;
		} else if (center < 5000) {
			cnt = 5;
		} else if (center < 10000) {
			cnt = 10;
		} else if (center < 50000) {
			cnt = 50;
		} else if (center < 100000) {
			cnt = 100;
		} else if (center < 500000) {
			cnt = 500;
		} else if (center >= 500000) {
			cnt = 1000;
		}
		cnt1 = cnt;
		center();
	}

	public void center() {
		int setcnt = 0;
		int setA = 0;
		chart[C1][C2] = 4;
		boolean frag = true;
		// 자동 세팅 값, 객체 생성

		PriceO priceT = null;
		while (frag) {
			int ren = r.nextInt(3) + 1;
			double a = (((float) (setcnt * cnt) / (float) (center)) - 1) * 100;
			double m = (float) (center * a) / (float) 100;
			if (Math.round(a * 100) / 100.0 > 30.00) {
				frag = false;
				break;
			}
			if (Math.round(a * 100) / 100.0 >= -30) {

				priceT = new PriceO(this);
				tc.add(priceT);
				tc.get(setA).setPrice(cnt1 - cnt);
				tc.get(setA).setYield(Math.round(a * 100) / 100.0 + "%");
				tc.get(setA).setMeny(Math.round(m) + "원");

				for (int i = 0; i < 1; i++) {
					int imsi = dao.serchS(tc.get(setA).getPrice(), stockN);
					if (imsi == -2) {
						tc.get(setA).setCnt(ren);

					} else if (imsi == -1) {
						i--;
					} else {
						tc.get(setA).setCnt(imsi);

					}
				}

				System.out.println(setA + 1 + "/ 가격 : " + tc.get(setA).getPrice() + " / 수량 : " + tc.get(setA).getCnt()
						+ " / 수익률 :" + tc.get(setA).getYield() + " / 수익 :" + tc.get(setA).getMeny());
				if (Math.round(a * 100) / 100.0 == 0) {
					centerN = setA;
					center1 = tc.get(centerN).getPrice();
				}
				setA++;

			}
			setcnt++;
			cnt1 = cnt1 + cnt;
		}
		for (int i = 0; i < tc.size(); i++) {
			if (i <= centerN) {
				tc.get(i).setB();
			} else {
				tc.get(i).setS();
			}
		}
		auto1();// 시간,종가 설정 기능
		auto3();// 최우선 매도 호가 auto 기능,sing2()호출
		auto2();// 최우선 매수 호가 auto 기능,sing()호출
		auto4();// 최우선 호가를 제외한 그 외 auto기능,sing4,3()호출

	}

	// client sell
	public void sell(int price, int cnt, String id, SendClient sc) {
		if (scT.size() > 0) {
			if (!scT.contains(sc)) {
				scT.add(sc);
			}
		} else {
			scT.add(sc);
		}
		new Thread(new Runnable() {

			@Override
			public void run() {
				if (tc.get(centerN + 1).getPrice() < price) {
					for (int i = (centerN + 2); i < tc.size(); i++) {
						if (tc.get(i).getPrice() == price) {
							tc.get(i).sing3(cnt, 1, id, sc);
							break;
						}
					}
				} else if (tc.get(centerN + 1).getPrice() == price) {
					tc.get(centerN + 1).sing2(cnt, 1, id, sc);
				} else if (tc.get(centerN).getPrice() == price) {
					if (tc.get(centerN).sing(cnt, 1, id, sc) == 1) {
						centerN--;
						sendB2();
						goinfo();
						if (C1 > C11) {
							chart[C1][C2] = 1;
							C1 = C1 - 1;

						} else {
//							if (C1 == C11) {
//								chart[C1][C2] = 3;
//							}
							C1 = C1 - 1;
							chart[C1][C2] = 3;
						}
					}
				} else if (tc.get(centerN).getPrice() > price) {
					for (int i = (centerN - 10); i < tc.size(); i++) {
						if (tc.get(i).getPrice() == price) {
							tc.get(i).sing4(cnt, 1, id, sc);
							break;
						}
					}
				}

				// System.out.println("----------------------------------");
				for (int i = centerN + 10; i > centerN - 10; i--) {
					if (i == centerN) {
//						System.out.println("가격(시장가) : " + tc.get(centerN).getPrice() + " / 매수수량 :"
//								+ tc.get(centerN).getCnt());
						broker.add("가격(시장가) : " + tc.get(centerN).getPrice() + " / 매수수량 :" + tc.get(centerN).getCnt());
					} else if (i > centerN) {
//						System.out.println("가격 : " + tc.get(i).getPrice() + " / 매도수량 :" + tc.get(i).getCnt());
						broker.add("가격 : " + tc.get(i).getPrice() + " / 매도수량 :" + tc.get(i).getCnt());
					} else if (i < centerN) {
						// System.out.println("가격 : " + tc.get(i).getPrice() + " / 매수수량 :" +
						// tc.get(i).getCnt());
						broker.add("가격 : " + tc.get(i).getPrice() + " / 매수수량 :" + tc.get(i).getCnt());
					}
				}
				// System.out.println("----------------------------------");
				sendData(broker);

			}
		}).start();
	}

	// client buy
	public void buysing(int price, int cnt, String id, SendClient sc) {
		if (scT.size() > 0) {
			if (!scT.contains(sc)) {
				scT.add(sc);
			}
		} else {
			scT.add(sc);
		}
		new Thread(new Runnable() {

			@Override
			public void run() {
				if (tc.get(centerN + 1).getPrice() < price) {
					for (int i = (centerN + 2); i < tc.size(); i++) {
						if (tc.get(i).getPrice() == price) {
							tc.get(i).sing3(cnt, 2, id, sc);
							break;
						}
					}
				} else if (tc.get(centerN + 1).getPrice() == price) {
					if (tc.get(centerN + 1).sing2(cnt, 2, id, sc) == 1) {
						centerN++;
						sendB2();
						goinfo();
						if (C1 >= C11) {
//							if (C1 == C11) {
//								chart[C1][C2] = 2;
//							}
							C1 = C1 + 1;
							chart[C1][C2] = 2;
						} else {
							chart[C1][C2] = 1;
							C1 = C1 + 1;
						}
					}
				} else if (tc.get(centerN).getPrice() == price) {
					tc.get(centerN).sing(cnt, 2, id, sc);
				} else if (tc.get(centerN).getPrice() > price) {
					for (int i = (centerN - 10); i < tc.size(); i++) {
						if (tc.get(i).getPrice() == price) {
							tc.get(i).sing4(cnt, 2, id, sc);
							break;
						}
					}
				}

//				System.out.println("----------------------------------");
				for (int i = centerN + 10; i > centerN - 10; i--) {
					if (i == centerN) {
//						System.out.println("가격(시장가) : " + tc.get(centerN).getPrice() + " / 매수수량 :"
//								+ tc.get(centerN).getCnt());
						broker.add("가격(시장가) : " + tc.get(centerN).getPrice() + " / 매수수량 :" + tc.get(centerN).getCnt());
					} else if (i > centerN) {
						// System.out.println("가격 : " + tc.get(i).getPrice() + " / 매도수량 :" +
						// tc.get(i).getCnt());
						broker.add("가격 : " + tc.get(i).getPrice() + " / 매도수량 :" + tc.get(i).getCnt());
					} else if (i < centerN) {
						// System.out.println("가격 : " + tc.get(i).getPrice() + " / 매수수량 :" +
						// tc.get(i).getCnt());
						broker.add("가격 : " + tc.get(i).getPrice() + " / 매수수량 :" + tc.get(i).getCnt());
					}
				}
				// System.out.println("----------------------------------");
				sendData(broker);

			}
		}).start();
	}

	// 그 외 호가
	private void auto4() {
		new Thread(new Runnable() {

			@Override
			public void run() {

				while (true) {
					broker = new ArrayList<>();
					int time = r.nextInt(2500);
					try {
						for (int i = 0; i < 3; i++) {
							int es = r.nextInt(2);
							es = es - 1;
							int rennum1 = r.nextInt((centerN + 10) - (centerN + 2));
							int rennum2 = r.nextInt((centerN - 1) - (centerN - 9));
							rennum1 = rennum1 + (centerN + 2);
							rennum2 = rennum2 + (centerN - 9);
							tc.get(rennum1).sing3(es, 0, "auto", null);

							tc.get(rennum2).sing4(es, 0, "auto", null);

						}
						// 차트,호가 출력부

						// System.out.println("----------------------------------");
						for (int i = centerN + 10; i > centerN - 10; i--) {
							if (i == centerN) {
								// System.out.println("가격(시장가) : " + tc.get(centerN).getPrice() + " / 매수수량 :"
								// + tc.get(centerN).getCnt());
								broker.add("가격(시장가) : " + tc.get(centerN).getPrice() + " / 매수수량 :"
										+ tc.get(centerN).getCnt());
							} else if (i > centerN) {
								// System.out.println("가격 : " + tc.get(i).getPrice() + " / 매도수량 :" +
								// tc.get(i).getCnt());
								broker.add("가격 : " + tc.get(i).getPrice() + " / 매도수량 :" + tc.get(i).getCnt());
							} else if (i < centerN) {
								// System.out.println("가격 : " + tc.get(i).getPrice() + " / 매수수량 :" +
								// tc.get(i).getCnt());
								broker.add("가격 : " + tc.get(i).getPrice() + " / 매수수량 :" + tc.get(i).getCnt());
							}
						}
						// System.out.println("----------------------------------");

						sendData(broker);
						// sendData1();

						Thread.sleep(time + 2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();

	}

	// 최우선 매도 호가
	private void auto3() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					int time = r.nextInt(2000);
					try {
						broker = new ArrayList<>();
						int es = r.nextInt(2);
						es = es - 1;
						if (tc.get(centerN + 1).sing2(es, 0, "auto", null) == 1) {
							centerN++;
							// 주주에게 종목 변동 값 알림
							sendB2();
							// 종목 변동 값 알림
							goinfo();
							if (C1 >= C11) {
//								if (C1 == C11) {
//									chart[C1][C2] = 2;
//								}
								C1 = C1 + 1;
								chart[C1][C2] = 2;
							} else {
								chart[C1][C2] = 1;
								C1 = C1 + 1;
							}
						}
						// 차트,호가 출력부

						// System.out.println("----------------------------------");
						for (int i = centerN + 10; i > centerN - 10; i--) {
							if (i == centerN) {
								// System.out.println("가격(시장가) : " + tc.get(centerN).getPrice() + " / 매수수량 :"
								// + tc.get(centerN).getCnt());
								broker.add("가격(시장가) : " + tc.get(centerN).getPrice() + " / 매수수량 :"
										+ tc.get(centerN).getCnt());
							} else if (i > centerN) {
								// System.out.println("가격 : " + tc.get(i).getPrice() + " / 매도수량 :" +
								// tc.get(i).getCnt());
								broker.add("가격 : " + tc.get(i).getPrice() + " / 매도수량 :" + tc.get(i).getCnt());
							} else if (i < centerN) {
								// System.out.println("가격 : " + tc.get(i).getPrice() + " / 매수수량 :" +
								// tc.get(i).getCnt());
								broker.add("가격 : " + tc.get(i).getPrice() + " / 매수수량 :" + tc.get(i).getCnt());
							}
						}
						// System.out.println("----------------------------------");

						sendData(broker);
						// sendData1();

						Thread.sleep(2000 + time);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	// 최우선 매수 호가
	private void auto2() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					broker = new ArrayList<>();
					int time = r.nextInt(2000);
					try {
						int es = r.nextInt(2);
						es = es - 1;
						if (tc.get(centerN).sing(es, 0, "auto", null) == 1) {
							centerN--;
							sendB2();
							goinfo();
							if (C1 > C11) {
								chart[C1][C2] = 1;
								C1 = C1 - 1;

							} else {
//								if (C1 == C11) {
//									chart[C1][C2] = 3;
//								}
								C1 = C1 - 1;
								chart[C1][C2] = 3;
							}
						}
						// 차트,호가 출력부

						// System.out.println("----------------------------------");
						for (int i = centerN + 10; i > centerN - 10; i--) {
							if (i == centerN) {
								// System.out.println("가격(시장가) : " + tc.get(centerN).getPrice() + " / 매수수량 :"
								// + tc.get(centerN).getCnt());
								broker.add("가격(시장가) : " + tc.get(centerN).getPrice() + " / 매수수량 :"
										+ tc.get(centerN).getCnt());
							} else if (i > centerN) {
								// System.out.println("가격 : " + tc.get(i).getPrice() + " / 매도수량 :" +
								// tc.get(i).getCnt());
								broker.add("가격 : " + tc.get(i).getPrice() + " / 매도수량 :" + tc.get(i).getCnt());
							} else if (i < centerN) {
								// System.out.println("가격 : " + tc.get(i).getPrice() + " / 매수수량 :" +
								// tc.get(i).getCnt());
								broker.add("가격 : " + tc.get(i).getPrice() + " / 매수수량 :" + tc.get(i).getCnt());
							}
						}
						// System.out.println("----------------------------------");

						sendData(broker);
						// sendData1();

						Thread.sleep(2000 + time);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	// time, 차트형태 설정,종가 설정
	public void auto1() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					boolean frag = true;
					while (frag) {
						broker = new ArrayList<String>();

						timecnt++;
						// 시간 조정 , 6시간 ->3초 기준 7200

						if (timecnt % 4 == 0) {
							C2++;
							chart[C1][C2] = chart[C1][C2 - 1];
							chart[C1][C2] = 4;
							C11 = C1;
						} else if (timecnt == 7200) {
							int centerL = 0;
							int centerH = 0;
							ArrayList<Integer> H = new ArrayList<>();
							ArrayList<Integer> L = new ArrayList<>();
							int cul = chart[0].length;

							// 시장 종류후 업데이트
							update();

							// DB 개별 종목 데이터값 저장.
							EstockDTO es = new EstockDTO();
							es.setName(stockN);
							es.setPrice(tc.get(centerN).getPrice());
							es.setPriceS(center1);

							for (int i = 0; i < cul; i++) {
								for (int z = C1; z < chart.length; z++) {
									if (chart[z][i] != 0) {
										centerH++;
									} else {
										break;
									}
								}
								H.add(centerH - 1);
								centerH = 0;
							}

							for (int i = 0; i < H.size(); i++) {
								if (centerH <= H.get(i)) {
									centerH = H.get(i);
								}
							}

							es.setPriceH(tc.get(centerH + centerN).getPrice());

							for (int i = 0; i < cul; i++) {
								for (int z = C1; z > 0; z--) {
									if (chart[z][i] != 0) {
										centerL++;
									} else {
										break;
									}
								}
								L.add(centerL - 1);
								centerL = 0;
							}

							for (int i = 0; i < L.size(); i++) {
								if (centerL <= L.get(i)) {
									centerL = L.get(i);
								}
							}

							es.setPriceL(tc.get(centerN - centerL).getPrice());

							dao.updateE(es);

							// DB에 모든 객체 데이터값 저장 .
							for (int i = 0; i < tc.size(); i++) {
								if (tc.get(i).goDB(stockN) == 2) {
									i--;
								}
							}

						}
						// sendData1();

						Thread.sleep(3000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}).start();
	}

	// 직렬화 전송
	private void sendData(ArrayList<String> broker1) {
		synchronized (this) {
			try {
				OutputStream os;
				ObjectOutputStream oos;
				data d = new data();
				d.setRow(C2);
				d.setCenterP(C11);
				d.setBroker(broker1);
				d.setevent(stockN);
				d.setChart(chart);
				for (int i = 0; i < socketT.size(); i++) {
					System.out.println("직렬화 전송 : "+socketT.get(i));
					os = socketT.get(i).getOutputStream();
					oos = new ObjectOutputStream(os);
					oos.reset();
					oos.writeObject(d);
					oos.flush();

				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void sendData1() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				broker = new ArrayList<>();
				for (int i = centerN + 10; i > centerN - 10; i--) {
					if (i == centerN) {
						System.out.println(
								"가격(시장가) : " + tc.get(centerN).getPrice() + " / 매수수량 :" + tc.get(centerN).getCnt());
						broker.add("가격(시장가) : " + tc.get(centerN).getPrice() + " / 매수수량 :" + tc.get(centerN).getCnt());
					} else if (i > centerN) {
						System.out.println("가격 : " + tc.get(i).getPrice() + " / 매도수량 :" + tc.get(i).getCnt());
						broker.add("가격 : " + tc.get(i).getPrice() + " / 매도수량 :" + tc.get(i).getCnt());
					} else if (i < centerN) {
						System.out.println("가격 : " + tc.get(i).getPrice() + " / 매수수량 :" + tc.get(i).getCnt());
						broker.add("가격 : " + tc.get(i).getPrice() + " / 매수수량 :" + tc.get(i).getCnt());
					}
				}
				sendData(broker);
			}
		}).start();
	}

	public void socketchk(Socket s, String y) {
		System.out.println(s + ":" + y + ":소켓 검사");
		if ("y".equals(y)) {
			socketT.add(s);
		} else {
			for (int i = 0; i < socketT.size(); i++) {
				if (socketT.get(i).equals(s)) {
					socketT.remove(i);
					break;
				}
			}
		}

	}

	public void objchk(SendClient s, String y) {
		if ("y".equals(y)) {
			scT.add(s);
		} else {
			for (int i = 0; i < socketT.size(); i++) {
				if (scT.get(i).equals(s)) {
					scT.remove(i);
					break;
				}
			}
		}

	}

	private void update() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < tc.size(); i++) {
					tc.get(i).fluct();
					if (tc.get(i).fluct() == 0) {
						--i;
						System.out.println("back");
					}
				}

			}
		}).start();
	}

	public void sendB(SendClient sc, String msg, String id) {

		String stock = dao.serchBI(id, stockN);
		if (stock.equals(stockN)) {
			System.out.println(msg);
			if (msg.equals("잔고 내역")) {
				if (scB.size() > 0) {
					if (!scB.contains(sc)) {
						scB.add(sc);
						totalID.add(id);
					}
				} else {
					scB.add(sc);
					totalID.add(id);
				}
				sendB2();
			} else {
				for (int i = 0; i < scB.size(); i++) {
					if (scB.get(i).equals(sc)) {
						scB.remove(i);
						totalID.remove(i);
						break;
					}
				}
			}
		}
	}

	private void sendB2() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < scB.size(); i++) {
					int buying = dao.serchB(totalID.get(i), stockN, 1);
					int cnt = dao.serchB(totalID.get(i), stockN, 2);
					if (cnt != 0) {
						double yield = tc.get(0).lastY(buying);
						double m = (float) (buying * yield) / (float) 100;
						String bs = "매수 단가  :" + buying;
						String cs = "수량  : " + cnt;
						String ys = "수익률  : " + yield + "%";
						String ms = "수익 : " + Math.round(m) + "원";
						String nows = "현재가 :" + tc.get(centerN).getPrice();
						String sendmsg = "##" + stockN + " | " + nows + " | " + bs + " | " + cs + " | " + ys + " | "
								+ ms + " |" + "*";
						scB.get(i).sendMsg(sendmsg);
					}
				}
			}

		}).start();
	}

	private void goinfo() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				if (scTT.size() != 0) {
					String yield = tc.get(centerN).getYield();
					String nows = "현재가 :" + tc.get(centerN).getPrice();
					String meny = tc.get(centerN).getMeny();
					String sendmsg = "!!" + stockN + " |      " + nows + "        |               " + yield + "/" + meny
							+ " |*";
					for (int i = 0; i < scTT.size(); i++) {
						scTT.get(i).sendMsg(sendmsg);
					}

				}

			}
		}).start();
	}

}
