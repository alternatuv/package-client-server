/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.client.java;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author Windows 10
 */
public class Client {
  public static void main(String[] args) throws IOException {
 
        Socket s = new Socket("127.0.0.1",1201);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msgin="", msgout="";
        while(!msgin.equals("end")){
            msgout = br.readLine();
            dout.writeUTF(msgout);
            msgin = din.readUTF();
            System.out.println(msgin);
        }
  }  
}
