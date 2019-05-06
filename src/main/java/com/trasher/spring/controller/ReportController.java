package com.trasher.spring.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trasher.spring.model.Admin;
import com.trasher.spring.model.Customer;
import com.trasher.spring.service.CustomerService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ReportController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/reportinvoices")
	public void getInvoices() {
		List<Customer> customers=customerService.completelist();
		int n=customers.size();
		String[] dates=new String[n];
		int[] counts=new int[n];
		ArrayList<String> months=new ArrayList<String>();

		for(int i=0;i<n;i++) {
			dates[i]=customers.get(i).getDate().substring(0,7);
		}
	    months=this.Dist(dates);
	    counts=this.getCount(dates);
	    
	    System.out.println(months.toString());
	    System.out.println(Arrays.toString(counts));
	}
	
	public static ArrayList<String> Dist(String[] num){
        int n=num.length;
        ArrayList<String> lis=new ArrayList<String>();
        for(int i=0;i<n;i++){
            int j;
            for(j=0;j<i;j++){
                if(num[i].equals(num[j])){
                    break;
                }
            }
            if(i==j){
                lis.add(num[i]);
            }
        }
        return lis;
    }


    public static int[] getCount(String[] num){
        int n=num.length;
        ArrayList<String> dis=Dist(num);
        int m=dis.size();
        int[] count=new int[m];
        for(int i=0;i<m;i++){
            int c=0;
            for(int j=0;j<n;j++){
                if(dis.get(i).equals(num[j])){
                    c++;
                }
            }
            count[i]=c;
        }
        return count;
    }


}
