package com;

public class student {
		
		private int sid;
		private String sname;
		
		public int getSid() {
			return sid;
		}
		public void setSid(int sid) {
			this.sid = sid;
		}
		public String getSname() {
			return sname;
		}
		public void setSname(String sname) {
			this.sname = sname;
		}
		@Override
		public String toString() {
			return "student [sid=" + sid + ", sname=" + sname + ", getSid()=" + getSid() + ", getSname()=" + getSname()
					+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
					+ "]";
		}
		
		
		
		
	

}
