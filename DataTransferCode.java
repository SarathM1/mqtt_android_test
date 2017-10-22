package com.example.pradeepaa.finger_print;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

public class FingerSensorSuccess extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        //String medit = editText2.getText().toString();
    }

    public void send_data(View v)
    {
        final String message = "Authentication Success...!!!" ;
        final String iadd = editText.getText().toString();
        new Thread(){
            @Override
            public void run()
            {
                try {
                    InetAddress addr = InetAddress.getByName(iadd);

                    DatagramSocket serverSocket = new DatagramSocket();
                    DatagramPacket msgPacket = new DatagramPacket(message.getBytes(),
                            message.getBytes().length, addr, 5000);
                    serverSocket.send(msgPacket);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),"sent",Toast.LENGTH_LONG).show();
                        }
                    });

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }.start();

    }

//    class BackgroundTask extends AsyncTask<String,Void,Void>
//    {
//        Socket s;
//        PrintWriter writer;
//
//        @Override
//        protected Void doInBackground(String... voids)
//        {
//            try {
//                String message = voids[0];
//                s = new Socket("255.255.255.255", 6000);
//                writer = new PrintWriter(s.getOutputStream());
//                writer.write(message);
//                writer.flush();
//                writer.close();
//                s.close();
//
//            }catch(IOException e)
//            {
//                e.printStackTrace();
//            }
//            return null;
//        }
//    }
}



