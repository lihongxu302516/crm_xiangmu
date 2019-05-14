package com.crm.util;

import java.util.ArrayList;
import java.util.List;

import com.crm.entity.User;

public class Test {
	public static void main(String[] args) {
		User user1=new User();
		User user2=new User();
		User user3=new User();
		List<User> userlist=new ArrayList<User>();
		user1.setUs_name("a");
		user1.setUs_quanzhong(90);
		userlist.add(user1);
		user2.setUs_name("b");
		user2.setUs_quanzhong(30);
		userlist.add(user2);
		user3.setUs_name("c");
		user3.setUs_quanzhong(60);
		userlist.add(user3);
		int a=0,b=0,c=0;
		for(int i=0;i<100000;i++) {
			QuanZhongFenPei q=new QuanZhongFenPei();
			User fenpei = q.fenpei(userlist);
			if("a".equals(fenpei.getUs_name())) {
				a++;
			}else if("b".equals(fenpei.getUs_name())) {
				b++;
			}else if("c".equals(fenpei.getUs_name())) {
				c++;
			}
		}
		 System.out.println("A:" + a );
	     System.out.println("B:" + b );
	     System.out.println("C:" + c );
	}

}
