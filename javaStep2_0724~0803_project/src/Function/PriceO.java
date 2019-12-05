package Function;


import java.util.ArrayList;
import java.util.Random;

import DB.BalanDTO;
import DB.DAO;
import DB.StockDTO;
import Server.SendClient;

public class PriceO {
	private int price;
	private int priceC;
	private int cnt;
	private double a;
	private String yield;
	private String meny;
	private ArrayList<String> idB = new ArrayList<>();
	private ArrayList<String> idS = new ArrayList<>();
	private ArrayList<Integer> cntB = new ArrayList<>();
	private ArrayList<Integer> cntS = new ArrayList<>();
	private ArrayList<SendClient> scT = new ArrayList<>();
	private ArrayList<BalanDTO> idT = null;
	private BalanDTO dtoB = null;

	private Fun t0;
	private Random r = new Random();
	private DAO dao = DAO.getInstence();
	
	public String getMeny() {
		return meny;
	}
	public void setMeny(String meny) {
		this.meny = meny;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getYield() {
		return yield;
	}
	public void setYield(String yield) {
		this.yield = yield;
	}
	
	public PriceO(Fun t0) {
		this.t0 = t0;
	}
	
	
	// 현재 가격 호가
	public int sing(int es, int sing, String id,SendClient sc) {
		synchronized (this) {
			int r1 = r.nextInt(5)+1;
			int r2 = r.nextInt(5)+1;

			if (es == 0) {
				cntB.add(r1);
				idB.add(id);
				cnt = cnt + r1;
			} else if (es == -1) {
				cnt = cnt - r2;
				algo2(r2, id);
				if (cnt <= 0) {
					cnt = cnt * -1;
					return 1;
				}
			} else if (sing == 2) {
				cntB.add(es);
				idB.add(id);
				cnt = cnt + es;
			} else if(sing == 1) {
				if(cnt-es>0) {
					cnt = cnt - es;
					algo2(es,id);
				}else if(cnt-es==0) {
					cnt = cnt - es;
					algo2(es,id);
					return 1;
				}else if(cnt-es<0) {
					cnt = cnt -es;
					cnt = cnt*(-1);
					algo2(es,id);
					return 1;
				}
			}
			return 0;

		}
	}

	// 현재 가격 (+1) 호가
	public int sing2(int es,int sing,String id,SendClient sc) {
		synchronized (this) {
			int ren = r.nextInt(5)+1;
			
			if (es == 0) {
				cnt = cnt + ren;
				cntS.add(ren);
				idS.add(id);
			} else if(es == -1) {
				cnt = cnt - ren;
				algo1(ren,id);
				if (cnt <= 0) {
					cnt = cnt * -1;
					return 1;
				}
			} else if(sing==2) {
				if(cnt-es==0) {
					cnt = cnt -es;
					algo1(es,id);
					return 1;
				} else if(cnt-es>0) {
					cnt = cnt - es;
					algo1(es,id);
				}else if(cnt-es<0) {
					cnt = cnt -es;
					cnt = cnt*(-1);
					algo1(es,id);
					return 1;
				}
			} else if(sing==1) {
				cnt = cnt+es;
				cntS.add(es);
				idS.add(id);
			}
			return 0;
			
		}
	}
	//매도 물량
	public int sing3(int es,int sing,String id,SendClient sc) {
		synchronized (this) {
			int ren = r.nextInt(6)+1;
			if (es == 0) {
				cnt = cnt + ren;
				cntS.add(ren);
				idS.add(id);
			} else if (es == -1) {
				cnt = cnt - ren;
				algo1(ren, id);
				if (cntB.size() != 0) {
					cntB.remove(0);
					idB.remove(0);
					
				}
				if (cnt <= 0) {
					cnt = 0;
					return price;
				}
			} else if (sing == 2) {
				if (cnt - es < 0) {
					sc.sendMsg("물량이 부족합니다.");
				} else {
					cnt = cnt - es;
					algo1(es, id);
					if (cntB.size() != 0) {
						cntB.remove(0);
						idB.remove(0);
					}
				}
			} else if(sing ==1) {
				cnt = cnt + es;
				cntS.add(es);
				idS.add(id);
			}
			return 0;

		}
	}
	//매수 물량
	public int sing4(int es,int sing,String id,SendClient sc) {
		synchronized (this) {
			
			int ren = r.nextInt(6)+1;
			if (es == 0) {
				cnt = cnt + ren;
				cntB.add(ren);
				idB.add(id);
			} else if(es == -1){
				cnt = cnt - ren;
				algo2(ren,id);				

				if(cntS.size()!=0) {
					cntS.remove(0);
					idS.remove(0);
				
				}
				if (cnt <= 0) {
					cnt = 0;
					return price;
				}
			}else if(sing == 2) {
				cnt = cnt + es;
				cntB.add(es);
				idB.add(id);
			}else if (sing == 1) {
				if (cnt - es < 0) {
					sc.sendMsg("물량이 부족합니다.");
				} else {
					cnt = cnt - es;
					algo2(es, id);
					if (cntS.size() != 0) {
						cntS.remove(0);
						idS.remove(0);
					}
				}
			}
			return 0;
			
		}
	}
	
	
	//DB 에 개인 종목  내역 넣기
	public int goDB(String stockN) {
		StockDTO dto = new StockDTO();
		dto.setNameS(stockN);
		dto.setPrice(price);
		dto.setCnt(cnt);
		//프로시저
		if(dao.procS(dto)) {
			return 1;
		}else {
			return 2;
		}
		
		//쿼리 select + insert + update
//		if (dao.serchS(price, stockN) == 0) {
//			if (dao.insertS(dto)) {
//				return 1;
//			}else {
//				return 2;
//				
//			}
//		} else if (dao.serchS(price, stockN) == 1) {
//			return 2;
//		}else {
//			if(dao.updateS(dto)) {
//				return 1;
//			}else {
//				return 2;
//			}
//		}
	}
	
	//알고리즘 1,2
	
	private void algo1(int r1,String id) {
		scT = t0.getScT(); //sever 객체  연동 하기
		synchronized (this) {
			int chk=0;
			int imsi=0;
			if(cntS.size()!=0) {
				imsi = cntS.get(chk);
				imsi = imsi - r1;
				if(imsi>0) {
					cntS.set(chk, imsi);
				
					for (int i = 0; i < scT.size(); i++) {
						if (scT.get(i).getMyid().equals(idS.get(chk))) {
							scT.get(i).sendMsg(r1 + "개 수량 매도 체결 완료");
							setDB(idS.get(chk),r1,2);
						} else if (scT.get(i).getMyid().equals(id)) {
							scT.get(i).sendMsg(r1 + "개 수량 매수 체결 완료");
							setDB(id,r1,1);
						}
					}
				}else if(imsi==0) {
					for (int i = 0; i < scT.size(); i++) {
						if (scT.get(i).getMyid().equals(idS.get(chk))) {
							scT.get(i).sendMsg(r1 + "개 수량 매도 체결 완료");
							setDB(idS.get(chk),r1,2);
						} else if (scT.get(i).getMyid().equals(id)) {
							scT.get(i).sendMsg(r1 + "개 수량 매수 체결 완료");
							setDB(id,r1,1);
						}
					}
					cntS.remove(chk);
					idS.remove(chk);
				}else if(imsi<0){
					while(imsi<0) {
						for (int i = 0; i < scT.size(); i++) {
							if (scT.get(i).getMyid().equals(idS.get(chk))) {
								scT.get(i).sendMsg(cntS.get(chk) + "개 수량 매도 체결 완료");
								setDB(idS.get(chk),cntS.get(chk),2);
							} else if (scT.get(i).getMyid().equals(id)) {
								scT.get(i).sendMsg(cntS.get(chk) + "개 수량 매수 체결 완료");
								setDB(id,cntS.get(chk),1);
							}
						}
						cntS.remove(chk);
						idS.remove(chk);
						if (cntS.size() != 0) {
							int imsi1 = cntS.get(chk);
							int bs = imsi;
							imsi = imsi1 + imsi;

							if (imsi == 0) {
								for (int i = 0; i < scT.size(); i++) {
									if (scT.get(i).getMyid().equals(idS.get(chk))) {
										scT.get(i).sendMsg(imsi1 + "개 수량 매도 체결 완료");
										setDB(idS.get(chk),imsi1,2);
									} else if (scT.get(i).getMyid().equals(id)) {
										scT.get(i).sendMsg(imsi1 + "개 수량 매수 체결 완료");
										setDB(id,imsi1,1);
									}
								}
								cntS.remove(chk);
								idS.remove(chk);
							} else if (imsi > 0) {
								for (int i = 0; i < scT.size(); i++) {
									if (scT.get(i).getMyid().equals(idS.get(chk))) {
										scT.get(i).sendMsg(bs*-1 + "개 수량 매도 체결 완료");
										setDB(idS.get(chk),bs*-1,2);
									} else if (scT.get(i).getMyid().equals(id)) {
										scT.get(i).sendMsg(bs*-1 + "개 수량 매수 체결 완료");
										setDB(id,bs*-1,1);
									}
								}
								cntS.set(chk, imsi);
							}
						} else {
							imsi = imsi * -1;
							cntB.add(imsi);
							idB.add(id);
						}
					}
				}
			} else {
				cntB.add(r1);
				idB.add(id);
			}

		}
	}						

	private void algo2(int r2,String id) {
		scT = t0.getScT();  //sever 객체  연동 하기
		synchronized (this) {
			int chk=0;
			int imsi=0;
			if(cntB.size()!=0) {
				imsi = cntB.get(chk);
				imsi = imsi - r2;
				if(imsi>0) {
					cntB.set(chk, imsi);
					for (int i = 0; i < scT.size(); i++) {
						if (scT.get(i).getMyid().equals(idB.get(chk))) {
							scT.get(i).sendMsg(r2 + "개 수량 매수 체결 완료");
							setDB(idB.get(chk),r2,1);
						} else if (scT.get(i).getMyid().equals(id)) {
							scT.get(i).sendMsg(r2 + "개 수량 매도 체결 완료");
							setDB(id,r2,2);
						}
					}
				}else if(imsi==0) {
					for (int i = 0; i < scT.size(); i++) {
						if (scT.get(i).getMyid().equals(idB.get(chk))) {
							scT.get(i).sendMsg(r2 + "개 수량 매수 체결 완료");
							setDB(idB.get(chk),r2,1);
						} else if (scT.get(i).getMyid().equals(id)) {
							scT.get(i).sendMsg(r2 + "개 수량 매도 체결 완료");
							setDB(id,r2,2);
						}
					}
					idB.remove(chk);
					cntB.remove(chk);
				}else if(imsi<0){
					while(imsi<0) {
						for (int i = 0; i < scT.size(); i++) {
							if (scT.get(i).getMyid().equals(idB.get(chk))) {
								scT.get(i).sendMsg(cntB.get(chk) + "개 수량 매수 체결 완료");
								setDB(idB.get(chk),cntB.get(chk),1);
							} else if (scT.get(i).getMyid().equals(id)) {
								scT.get(i).sendMsg(cntB.get(chk) + "개 수량 매도 체결 완료");
								setDB(id,cntB.get(chk),2);
							}
						}
						cntB.remove(chk);
						idB.remove(chk);
						if(cntB.size()!=0) {
							int imsi1 = cntB.get(chk);
							int bs = imsi;
							imsi = imsi1 + imsi;
							if(imsi==0) {
								for (int i = 0; i < scT.size(); i++) {
									if (scT.get(i).getMyid().equals(idB.get(chk))) {
										scT.get(i).sendMsg(imsi1 + "개 수량 매수 체결 완료");
										setDB(idB.get(chk),imsi1,1);
									} else if (scT.get(i).getMyid().equals(id)) {
										scT.get(i).sendMsg(imsi1 + "개 수량 매도 체결 완료");
										setDB(id,imsi1,2);
									}
								}
								cntB.remove(chk);
								idB.remove(chk);
							}else if(imsi>0){
								for (int i = 0; i < scT.size(); i++) {
									if (scT.get(i).getMyid().equals(idB.get(chk))) {
										scT.get(i).sendMsg(bs*-1 + "개 수량 매수 체결 완료");
										setDB(idB.get(chk),bs*-1,1);
									} else if (scT.get(i).getMyid().equals(id)) {
										scT.get(i).sendMsg(bs*-1 + "개 수량 매도 체결 완료");
										setDB(id,bs*-1,2);
									}
								}
								cntB.set(chk, imsi);
							}
							
						}else {
							imsi = imsi*-1;
							cntS.add(imsi);
							idS.add(id);
						}
					}
				}
				
			}else {
				cntS.add(r2);
				idS.add(id);
			}
		}
	}
		
	//잔고 내역 전송*-
	public void balance() {
		
	}
	
	//개인 회원 별 DB 저장
	private void setDB(String id, int cnt, int clas) {
		synchronized (this) {
			dtoB = new BalanDTO();
			dtoB.setId(id);
			dtoB.setEvent(t0.getStockN());
			int buysum = dao.serchB(id, t0.getStockN(),1);
			int cntsum = dao.serchB(id, t0.getStockN(), 2);
			if (clas == 1) {// 1==매수
				if (buysum == 0) { // 0==null값
					dtoB.setBuying(price);
					dtoB.setTotalC(0 + "원");
					dtoB.setYield(lastY(-1) + "%");
					dtoB.setTotalM(cnt);
					dtoB.setSell(0);
					dao.insertB(dtoB);
				} else {
					double d = (float)((price*cnt)+(buysum*cntsum))/(float)(cnt+cntsum);
					double c = (float) d * lastY(d) / (float) 100;
					dtoB.setBuying(Math.round(d));
					dtoB.setTotalC(Math.round(c) + "원");
					dtoB.setYield(lastY(Math.round(d)) + "%");
					dtoB.setTotalM(cnt+cntsum);
					dao.updateB(dtoB);
				}
			} else {
				double d = (float)((price*(cntsum-cnt))+(buysum*cntsum))/(float)((cntsum-cnt)+cntsum);
				double c = (float) d * lastY(d) / (float) 100;
				dtoB.setBuying(Math.round(d));
				dtoB.setTotalC(Math.round(c) + "원");
				dtoB.setYield(lastY(Math.round(d)) + "%");
				dtoB.setTotalM(cnt);
				dtoB.setSell(price);
				dao.procB(dtoB);
			}
		}
	}

	//시장 종료 후 업데이트
	public int fluct() {
		idT = dao.getListB();
		if (idT != null) {
			if("error".equals(idT.get(0).getId())){
				return 0;
			}else {
				for (int i = 0; i < idT.size(); i++) {
					if (idT.get(i).getTotalM() != 0) {
						double y = lastY(idT.get(i).getBuying());
						double c = (float) ((idT.get(i).getBuying()) * y) / (float) 100;
						dtoB = new BalanDTO();
						dtoB.setId(idT.get(i).getId());
						dtoB.setEvent(t0.getStockN());
						dtoB.setTotalC(Math.round(c) + "원");
						dtoB.setYield(y + "%");
						dao.updateB(dtoB);
					}
				}
			}
		}
		return 1;
	}
	//현재가 에서 현재 적용되는 가격 객체 수익률 계산 매서드
	public double lastY(double chk) {
		priceC= t0.centerP();
		if(chk==-1) {
			a = (((float) (priceC * 100) / (float) (price * 100)) - 1) * 100;
			a = (Math.round(a * 100) / 100.0);
			return a;
		}else {
			a = (((float) (priceC * 100) / (float) (chk * 100)) - 1) * 100;
			a = (Math.round(a * 100) / 100.0);
			return a;
		}
	}
	public void setB() {
		//DB 잔고 , ID 세팅
		cntB.add(cnt);
		idB.add("auto");
		
	}
	
	public void setS() {
		//DB 잔고 , ID 세팅
		cntS.add(cnt);
		idS.add("auto");
		
		
	}
}
