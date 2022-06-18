
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.View;

public class Manager extends javax.swing.JFrame {

    static int MyPort = 4431;
    static int MinerPort = 4441;
    static int Advisor_port = 5000;
    static int confidance_c = 1;
    static boolean Attaker_51 = false;
    static List<Device_inf> list_Devices = new ArrayList<Device_inf>();
    static List<Integer> list_managers = new ArrayList<Integer>();
    static List<Integer> Managers_accept = new ArrayList<Integer>();

    static List<Block> Blockchain = new ArrayList<Block>();
    static String HASH_DATA;
    static String PROOF_WORK;
    static boolean with_VTA = true;
    static String MAC_IoT_D;
    static int Ratio;

    public Manager() {
        initComponents();
        label_address.setText(Integer.toString(MyPort));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        show = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        label_address = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(200, 100));

        jButton1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(90, 0, 90));
        jButton1.setText("Start Listen");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        show.setColumns(20);
        show.setRows(5);
        jScrollPane1.setViewportView(show);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setText("Manager");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Logs :");

        label_address.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(486, 486, 486)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label_address, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(211, 211, 211))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_address, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        show.append("Manager is started......\n");
        //send_address();
        new contact_advisor().start();
        new show_info().start();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_address;
    private javax.swing.JTextArea show;
    // End of variables declaration//GEN-END:variables

    public class contact_advisor extends Thread {

        public void run() {

            ////////  Start conection part /////////////////////////////
            InetAddress address = null;
            try {
                address = InetAddress.getLocalHost();
            } catch (UnknownHostException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            }
            Socket s1 = null;
            String line = null;
            BufferedReader br = null;
            BufferedReader is = null;
            PrintWriter os = null;

            try {
                s1 = new Socket(address, Advisor_port); // You can use static final constant PORT_NUM
                br = new BufferedReader(new InputStreamReader(System.in));
                is = new BufferedReader(new InputStreamReader(s1.getInputStream()));
                os = new PrintWriter(s1.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
                show.append("IO Exception\n");
            }
            ////////  End conection part /////////////////////////////

            String response = null;
            show.append("░▒▒▒▓▓▓▓████████████████【﻿Send the Address to the Advisor】 ███████████████████▓▓▓▓▒▒▒░\n");
            os.println("MyAddress");
            os.flush();
            os.println(MyPort);
            os.flush();

            try {
                // get the BC
                response = is.readLine();

                if (response.compareTo("send_BC") == 0) {

                    int sizeBC = Integer.parseInt(is.readLine());

                    for (int k = 0; k < sizeBC; k++) {
                        //  >>>>>>>>>>>>>>>>>>>>>>  test f VTA
                        // This part is for the attacker where have fake BC, in order to control more then 51% of the network.
                        if (Attaker_51) {  
                            if (k == 2) {
                                String S1, S2, S3, S4, S5;
                                BigInteger b1, b2;
                                S1 = is.readLine();
                                S2 = is.readLine();
                                S2 = "Faked Information";
                                S3 = is.readLine();
                                S4 = is.readLine();
                                b1 = new BigInteger(is.readLine());
                                b2 = new BigInteger(is.readLine());
                                S5 = is.readLine();
                                Blockchain.add(new Block(S1, S2, S3, S4, b1, b2, S5));
                                show.append("【﻿Ｉ　ｍ　ａｔｔａｃｋｅｒ，　ｍｙ　ｆａｋｅｄ　ｂｌｏｃｋｃｈａｉｎ　ｉｓ：】\n");

                            } else {
                                Blockchain.add(new Block(is.readLine(), is.readLine(), is.readLine(), is.readLine(),
                                        new BigInteger(is.readLine()), new BigInteger(is.readLine()), is.readLine()));
                            }
                        } else {
                            Blockchain.add(new Block(is.readLine(), is.readLine(), is.readLine(), is.readLine(),
                                    new BigInteger(is.readLine()), new BigInteger(is.readLine()), is.readLine()));
                        }

                    }
                } else if (response.compareTo("Network_damaged") == 0) {
                    show.append("Advisor: The Network is damaged\n");
                } else if (response.compareTo("Not_send_BC") == 0) {
                    show.append("Advisor: Your are the First Manager, your Blockchain is empty\n");
                }

                show.append("<<<<< Start Blockchain >>>>>>>\n");
                for (int i = 0; i < Manager.Blockchain.size(); i++) {
                    show.append("--------  BLOCK N= " + (i + 1) + "--------\n");
                    show.append("Provious Hash: " + Manager.Blockchain.get(i).Pro_Hash + "\n");
                    show.append("New DATA: " + Manager.Blockchain.get(i).Data + "\n");
                    show.append("Hash:  " + Manager.Blockchain.get(i).Hash + "\n");
                    show.append("Proof of Work: " + Manager.Blockchain.get(i).Proof_w + "\n");
                    show.append("The Public key (e,n):\n");
                    show.append("e: " + Manager.Blockchain.get(i).public_k_e + "\n");
                    show.append("n: " + Manager.Blockchain.get(i).public_k_n + "\n");
                    show.append("Digital Signature: " + Manager.Blockchain.get(i).signature + "\n");
                }
                show.append("<<<<< End Blockchain >>>>>>>\n");

            } catch (IOException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                is.close();
                os.close();
                br.close();
                s1.close();
            } catch (IOException ex) {
                show.append("Connection Closed\n");
            }

        }
    }

    /*  
    void send_address() {

        ////////  Start conection part /////////////////////////////
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        Socket s1 = null;
        String line = null;
        BufferedReader br = null;
        BufferedReader is = null;
        PrintWriter os = null;

        try {
            s1 = new Socket(address, 5000); // You can use static final constant PORT_NUM
            br = new BufferedReader(new InputStreamReader(System.in));
            is = new BufferedReader(new InputStreamReader(s1.getInputStream()));
            os = new PrintWriter(s1.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            show.append("IO Exception\n");
        }
        ////////  End conection part /////////////////////////////

        String response = null;
        show.append("▁ ▂ ▄ ▅ ▆ ▇ █ 【﻿Send the Address to the Advisor】 █ ▇ ▆ ▅ ▄ ▂ ▁\n");
        os.println("MyAddress");
        os.flush();
        os.println(MyPort);
        os.flush();
        
        
        
        
        

        //System.out.println("********* End *****************");
        try {
            is.close();
            os.close();
            br.close();
            s1.close();
        } catch (IOException ex) {
            show.append("Connection Closed\n");
        }
    }
     */
    public class Block {

        String Pro_Hash;
        String Data;
        String Hash;
        String Proof_w;
        BigInteger public_k_e;
        BigInteger public_k_n;
        String signature;

        Block(String Pro_Hash, String Data, String Hash, String Proof_w, BigInteger public_k_e, BigInteger public_k_n, String signature) {
            this.Pro_Hash = Pro_Hash;
            this.Data = Data;
            this.Hash = Hash;
            this.Proof_w = Proof_w;
            this.public_k_e = public_k_e;
            this.public_k_n = public_k_n;
            this.signature = signature;
        }

    }

    public class show_info extends Thread {

        public void run() {

            Socket s = null;
            ServerSocket ss2 = null;

            try {
                ss2 = new ServerSocket(MyPort); // can also use static final PORT_NUM , when defined

            } catch (IOException e) {
                e.printStackTrace();
                show.append("Server error\n");

            }

            while (true) {
                try {
                    // start the function of the server
                    s = ss2.accept();
                    ServerThread st = new ServerThread(s);
                    st.start();

                } catch (Exception e) {
                    e.printStackTrace();
                    show.append("Connection Error\n");

                }
            }
        }
    }

    class ServerThread extends Thread {

        String line = null;
        BufferedReader is = null;
        PrintWriter os = null;
        Socket s = null;
        boolean exist_D = false;

        public ServerThread(Socket s) {
            this.s = s;
        }

        public void run() {
            try {
                is = new BufferedReader(new InputStreamReader(s.getInputStream()));
                os = new PrintWriter(s.getOutputStream());

            } catch (IOException e) {
                show.append("IO error in server thread\n");
            }

            try {
                line = is.readLine();
                if (line.compareTo("authenticate") == 0) {
                    show.append("**************************************** 【﻿Authenticate New Device】 ****************************************\n");

                    authentication();
                    show.append("░▒▓█ Ｅｎｄ　Ａｕｔｈｅｎｔｉｃａｔｉｏｎ █▓▒░\n");
                } else if (line.compareTo("add_DATA") == 0) {
                    show.append("░▒▒▒▓▓▓▓█████████████████████████ 【Getting New Data】 █████████████████████████▓▓▓▓▒▒▒░\n");
                    // get all the address of the managers from the advisor
                    get_addr_of_managers();

                    if (with_VTA == false) {
                        if (check_registration()) {
                            create_block();
                            if (validate_new_block()) {
                                share_block(true);
                            } else {
                                share_block(false);
                            }

                        }
                    } else {
                        if (check_registration()) {
                            create_block();
                            VTA();
                        }

                    }

                } else if (line.compareTo("info_BC?") == 0) {
                    // 
                    show.append("▁▂▄▅▆▆▆▇████████████████ 【Ｃｏｎｓｕｌｔｅ　Ｔｈｅ　Ｂｌｏｃｋｃｈａｉｎ】 ████████████████▇▆▆▅▄▂▁\n");
                    Read_info_BC();
                } else if (line.compareTo("add_block?") == 0) {
                    add_block();
                } else if (line.compareTo("give_BC") == 0) {
                    send_BC();
                } else if (line.compareTo("get_cc") == 0) {
                    os.println(confidance_c);
                    os.flush();
                } else if (line.compareTo("Increase_cc") == 0) {
                    confidance_c = confidance_c + 1;
                    show.append("The Confidance Criteria is Increased to:" + confidance_c + "\n");

                } else if (line.compareTo("punish") == 0) {
                    confidance_c = 1;
                    show.append("【﻿Ｙｏｕｒ　ａｒｅ　ｐｕｎｉｓｈｅｄ，　ｍａｋｅ　ｎｅｗ　ｃｏｎｎｅｃｔｉｏｎ　ｗｉｔｈ　ｔｈｅ　Ａｄｖｉｓｏｒ．】\n");
                    show.append("The new confidance criteria is " + confidance_c + ".\n");
                }

            } catch (IOException e) {

                line = this.getName(); //reused String line for getting thread name
                show.append("IO Error/ Client " + line + " terminated abruptly\n");
            } catch (NullPointerException e) {
                line = this.getName(); //reused String line for getting thread name
                show.append("Client " + line + " Closed\n");
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    //show.append("Connection Closing..");
                    if (is != null) {
                        is.close();
                        // show.append(" Socket Input Stream Closed");
                    }

                    if (os != null) {
                        os.close();
                        //show.append("Socket Out Closed");
                    }
                    if (s != null) {
                        s.close();
                        //show.append("Socket Closed");
                    }

                } catch (IOException ie) {
                    //show.append("Socket Close Error");
                }
            }//end finally
        }

        void send_BC() {
            os.println(Integer.toString(Blockchain.size()));
            os.flush();

            for (int i = 0; i < Blockchain.size(); i++) {
                os.println(Blockchain.get(i).Pro_Hash);
                os.flush();
                os.println(Blockchain.get(i).Data);
                os.flush();
                os.println(Blockchain.get(i).Hash);
                os.flush();
                os.println(Blockchain.get(i).Proof_w);
                os.flush();
                os.println(Blockchain.get(i).public_k_e);
                os.flush();
                os.println(Blockchain.get(i).public_k_n);
                os.flush();
                os.println(Blockchain.get(i).signature);
                os.flush();
            }

        }

        void add_block() throws IOException {
            String pro_hash, data, hash, proof_w, signature;
            BigInteger public_k_e, public_k_n;

            // result total
            line = is.readLine();  //<<<<<<<
            //show.append("44444");

            if (line.compareTo("Block_accepted") == 0) {
                pro_hash = is.readLine();
                data = is.readLine();
                hash = is.readLine();
                proof_w = is.readLine();
                signature = is.readLine();
                public_k_e = new BigInteger(is.readLine());
                public_k_n = new BigInteger(is.readLine());

                Blockchain.add(new Block(pro_hash, data, hash, proof_w, public_k_e, public_k_n, signature));
                show.append("░▒▒▒▓▓▓▓███████████████████ 【 Ｔｈｅ　Ｎｅｗ Ｂｌｏｃｋ　ｉｓ　ａｄｄｅｄ 】 ███████████████████▓▓▓▓▒▒▒░\n");

            }
            show.append("<<<<< Start Blockchain >>>>>>>\n");
            for (int i = 0; i < Manager.Blockchain.size(); i++) {
                show.append("--------  BLOCK N= " + (i + 1) + "--------\n");
                show.append("Provious Hash: " + Manager.Blockchain.get(i).Pro_Hash + "\n");
                show.append("New DATA: " + Manager.Blockchain.get(i).Data + "\n");
                show.append("Hash:  " + Manager.Blockchain.get(i).Hash + "\n");
                show.append("Proof of Work: " + Manager.Blockchain.get(i).Proof_w + "\n");
                show.append("The Public key (e,n):\n");
                show.append("e: " + Manager.Blockchain.get(i).public_k_e + "\n");
                show.append("n: " + Manager.Blockchain.get(i).public_k_n + "\n");
                show.append("Digital Signature: " + Manager.Blockchain.get(i).signature + "\n");
            }
            show.append("<<<<< End Blockchain >>>>>>>\n");

        }

        void authentication() throws IOException, NoSuchAlgorithmException {
            String hash_key;
            os.println("MAC?");
            os.flush();

            line = is.readLine();
            for (int i = 0; i < list_Devices.size(); i++) {
                if (line.compareTo(list_Devices.get(i).MAC) == 0) {
                    exist_D = true;
                    break;
                }

            }
            if (exist_D) {
                show.append("Failed Authentication, This Device is registred later ! \n");
                os.println("Fail, you are registred later !");
                os.flush();

            } else {
                // add Mac Address and random (public,private) keys:
                hash_key = Add_Keys(line);
                // send the hash of the private key to the Device
                os.println("Hash_PK");
                os.flush();

                os.println(hash_key);
                os.flush();

                os.println("Registarion operation is succeful");
                os.flush();
            }

            // show all the device registred
            //for (int i=0; i<list_Devices.size();i++){
            //show.append("size list="+list_Devices.size()+" add:"+list_Devices.get(i).MAC);}
        }

        String Add_Keys(String MAC) throws NoSuchAlgorithmException {
            BigInteger e, d, n;
            // communicate the Miner so, the in this case the manager is considered as client and the Miner is as server.

            ////////  Start conection part /////////////////////////////
            InetAddress address = null;
            try {
                address = InetAddress.getLocalHost();
            } catch (UnknownHostException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            }
            Socket s1 = null;
            String line = null;
            BufferedReader br = null;
            BufferedReader is = null;
            PrintWriter os = null;

            try {
                s1 = new Socket(address, MinerPort);
                br = new BufferedReader(new InputStreamReader(System.in));
                is = new BufferedReader(new InputStreamReader(s1.getInputStream()));
                os = new PrintWriter(s1.getOutputStream());
            } catch (IOException ef) {
                ef.printStackTrace();
                System.err.print("IO Exception");
            }

            ////////   End conection part /////////////////////////////
            String MinRes = null;
            String password;
            try {

                os.println("Key?");
                os.flush();
                e = new BigInteger(is.readLine());
                d = new BigInteger(is.readLine());
                n = new BigInteger(is.readLine());

                password = Hash1x2x3x5(e.toString());
                //show.append("e ="+e); show.append("d ="+d); show.append("n ="+n);
                show.append("The device is authenticated successfully\n");
                show.append("MAC|ID :" + MAC + "\n");
                show.append("e :" + e + "\n");
                show.append("d :" + d + "\n");
                show.append("n :" + n + "\n");
                show.append("Password :" + password + "\n");
                list_Devices.add(new Device_inf(MAC, e, d, n, password));

                return Hash1x2x3x5(e.toString());

            } catch (IOException ef) {
                ef.printStackTrace();
                show.append("Socket read Error\n");
            } finally {

                try {
                    is.close();
                    os.close();
                    br.close();
                    s1.close();
                } catch (IOException ex) {
                    //show.append("Connection Closed");  
                }

            }

            return null;
        }

        // get all the address of the managers from the advisor
        void get_addr_of_managers() throws UnknownHostException, IOException {
            // initialize the list of the managers
            list_managers = new ArrayList<Integer>();
            InetAddress address = InetAddress.getLocalHost();

            Socket s1 = new Socket(address, Advisor_port);
            String line = null;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader is = new BufferedReader(new InputStreamReader(s1.getInputStream()));
            PrintWriter os = os = new PrintWriter(s1.getOutputStream());

            os.println("get_manag_addr");
            os.flush();
            // receive the number of the managers
            int num_man = Integer.parseInt(is.readLine());
            System.out.println("list of managers:");
            for (int i = 0; i < num_man; i++) {
                list_managers.add(Integer.parseInt(is.readLine()));
                System.out.println(list_managers.get(i));
            }

            try {
                is.close();
                os.close();
                br.close();
                s1.close();
            } catch (IOException ex) {
                show.append("Connection Closed\n");
            }

        }

        boolean check_registration() throws IOException {
            String password;

            // get MAC Device:
            os.println("MAC?");
            os.flush();
            // the public and the private keys.
            MAC_IoT_D = is.readLine();
            password = is.readLine();
            // test the existence of the device
            for (int i = 0; i < list_Devices.size(); i++) {
                if (MAC_IoT_D.compareTo(list_Devices.get(i).MAC) == 0 && password.compareTo(list_Devices.get(i).Password) == 0) {
                    exist_D = true;

                    return true;
                }

            }
            if (!exist_D) {
                // the device is not registred in the manager
                //show.append("You have be registred in the Manager !");
                os.println("Not_registred");
                os.flush();
            }
            return false;
        }

        void create_block1() throws IOException, NoSuchAlgorithmException {
            String DATA;
            String hash;
            String signature = "0000";  // 

            // the device is registred in the manager, so the manager requests the DATA.
            os.println("DATA?");
            os.flush();

            line = is.readLine();
            DATA = line;
            // encrypting the DATA
            DATA = encrypt(MAC_IoT_D, DATA);

            // request the Miner about the hash and Proof od work:
            Request_Proof_W(DATA);

            // get the public key (e,N)
            BigInteger public_k_e = null, public_k_n = null, private_k_d = null;
            // Search for the public key appropriete with this device
            for (int i = 0; i < list_Devices.size(); i++) {
                if (MAC_IoT_D.compareTo(list_Devices.get(i).MAC) == 0) {
                    public_k_e = list_Devices.get(i).e;
                    public_k_n = list_Devices.get(i).n;
                    private_k_d = list_Devices.get(i).d;
                    break;
                }
            }

            // signature                
            BigInteger msg = new BigInteger(HASH_DATA.getBytes());
            byte[] encrypte = msg.modPow(private_k_d, public_k_n).toByteArray();
            signature = toHex(encrypte);

            // create the Block by the information:
            //genisis block
            if (Manager.Blockchain.size() == 0) {
                Manager.Blockchain.add(new Block("0000", DATA, HASH_DATA, PROOF_WORK, public_k_e, public_k_n, signature));

            } else {
                Manager.Blockchain.add(new Block(Manager.Blockchain.get(Manager.Blockchain.size() - 1).Hash, DATA, HASH_DATA, PROOF_WORK, public_k_e, public_k_n, signature));
            }

        }

        void create_block() throws IOException, NoSuchAlgorithmException {
            String DATA;
            String Previous_H;
            String signature = "0000";

            // The device is registred in the manager, 
            //1) so, the manager requests the DATA.
            os.println("DATA?");
            os.flush();

            line = is.readLine();
            DATA = line;
            // encrypting the DATA
            DATA = encrypt(MAC_IoT_D, DATA);

            //2) get the public key (e,N)
            BigInteger public_k_e = null, public_k_n = null, private_k_d = null;
            // Search for the public key appropriete with this device
            for (int i = 0; i < list_Devices.size(); i++) {
                if (MAC_IoT_D.compareTo(list_Devices.get(i).MAC) == 0) {
                    public_k_e = list_Devices.get(i).e;
                    public_k_n = list_Devices.get(i).n;
                    private_k_d = list_Devices.get(i).d;
                    break;
                }
            }

            // 3) Get previous hash
            if (Manager.Blockchain.size() == 0) {
                //genisis block
                Previous_H = "0000";
            } else {
                Previous_H = Manager.Blockchain.get(Manager.Blockchain.size() - 1).Hash;
            }

            //4) 5) request the Miner about the hash and Proof of work of the block:
            Request_Proof_W(Previous_H + DATA + public_k_e.toString() + public_k_n.toString());

            //6) signature                
            BigInteger msg = new BigInteger(HASH_DATA.getBytes());
            byte[] encrypte = msg.modPow(private_k_d, public_k_n).toByteArray();
            signature = toHex(encrypte);

            // create the Block by the information:
            Manager.Blockchain.add(new Block(Previous_H, DATA, HASH_DATA, PROOF_WORK, public_k_e, public_k_n, signature));

        }

        void share_block(boolean sharing) {

            // contact all managers
            for (int i = 0; i < list_managers.size(); i++) {
                // eleminate this manager.
                if (list_managers.get(i) != MyPort) {

                    InetAddress address = null;
                    try {
                        address = InetAddress.getLocalHost();
                    } catch (UnknownHostException ex) {
                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Socket s1 = null;
                    String line = null;
                    BufferedReader br = null;
                    BufferedReader is = null;
                    PrintWriter os = null;

                    //      begin connection part 
                    try {
                        s1 = new Socket(address, list_managers.get(i));
                        br = new BufferedReader(new InputStreamReader(System.in));
                        is = new BufferedReader(new InputStreamReader(s1.getInputStream()));
                        os = new PrintWriter(s1.getOutputStream());
                    } catch (IOException ef) {
                        ef.printStackTrace();
                        System.err.print("IO Exception");
                    }

                    ////////   End conection part /////////////////////////////
                    os.println("add_block?");
                    os.flush();
                    // if this blockchain equals the others blockchains
                    if (sharing) {

                        os.println("Block_accepted");
                        os.flush();
                        // the new block
                        os.println(Blockchain.get(Blockchain.size() - 1).Pro_Hash);
                        os.flush();
                        os.println(Blockchain.get(Blockchain.size() - 1).Data);
                        os.flush();
                        os.println(Blockchain.get(Blockchain.size() - 1).Hash);
                        os.flush();
                        os.println(Blockchain.get(Blockchain.size() - 1).Proof_w);
                        os.flush();
                        os.println(Blockchain.get(Blockchain.size() - 1).signature);
                        os.flush();
                        os.println(Blockchain.get(Blockchain.size() - 1).public_k_e.toString());
                        os.flush();
                        os.println(Blockchain.get(Blockchain.size() - 1).public_k_n.toString());
                        os.flush();

                    } else {
                        os.println("Block_Not_accepted");
                        os.flush();

                    }

                }
            }

            if (sharing == false) {
                // remoe the new block
                Blockchain.remove(Blockchain.size() - 1);
                show.append("░▒▓███████ Ｔｈｅ　Ｂｌｏｃｋ　ｉｓ　ｒｅｊｅｃｔｅｄ　ｆｏｒｍ　ｔｈｅ　ＢＣ　ｎｅｔｗｏｒｋ ███████▓▒░\n");
            } else {
                show.append("░▒▓███████ Ｔｈｅ　Ｂｌｏｃｋ　ｉｓ　ａｃｃｅｐｔｅｄ　ｆｏｒｍ　ｔｈｅ　ＢＣ　ｎｅｔｗｏｒｋ ███████▓▒░\n");
            }

            show.append("<<<<< Start Blockchain >>>>>>>\n");
            for (int i = 0; i < Manager.Blockchain.size(); i++) {
                show.append("--------  BLOCK N= " + (i + 1) + "--------\n");
                show.append("Provious Hash: " + Manager.Blockchain.get(i).Pro_Hash + "\n");
                show.append("New DATA: " + Manager.Blockchain.get(i).Data + "\n");
                show.append("Hash:  " + Manager.Blockchain.get(i).Hash + "\n");
                show.append("Proof of Work: " + Manager.Blockchain.get(i).Proof_w + "\n");
                show.append("The Public key (e,n):\n");
                show.append("e: " + Manager.Blockchain.get(i).public_k_e + "\n");
                show.append("n: " + Manager.Blockchain.get(i).public_k_n + "\n");
                show.append("Digital Signature: " + Manager.Blockchain.get(i).signature + "\n");
            }
            show.append("<<<<< End Blockchain >>>>>>>\n");

        }

        void Read_info_BC() throws IOException, NoSuchAlgorithmException {
            String pro_hash, data, hash, proof_w, signature, public_k_e, public_k_n;
            boolean conflit = false;
            System.out.println("Test if the BC receeived equels own BC:");
            // 1) we test if the BC received equals own BC.
            for (int j = 0; j < Blockchain.size(); j++) {
                pro_hash = is.readLine();
                data = is.readLine();
                hash = is.readLine();
                proof_w = is.readLine();
                signature = is.readLine();
                public_k_e = is.readLine();
                public_k_n = is.readLine();

                if (pro_hash.compareTo(Blockchain.get(j).Pro_Hash) != 0
                        || data.compareTo(Blockchain.get(j).Data) != 0
                        || hash.compareTo(Blockchain.get(j).Hash) != 0
                        || proof_w.compareTo(Blockchain.get(j).Proof_w) != 0
                        || signature.compareTo(Blockchain.get(j).signature) != 0
                        || public_k_e.compareTo(Blockchain.get(j).public_k_e.toString()) != 0
                        || public_k_n.compareTo(Blockchain.get(j).public_k_n.toString()) != 0) {
                    conflit = true;
                }
                System.out.println(Blockchain.get(j).Pro_Hash + " <<< >>> " + pro_hash);
                System.out.println(Blockchain.get(j).Data + " <<< >>> " + data);
                System.out.println(Blockchain.get(j).Hash + " <<< >>> " + hash);
                System.out.println(Blockchain.get(j).Proof_w + " <<< >>> " + proof_w);
                System.out.println(Blockchain.get(j).signature + " <<< >>> " + signature);
                System.out.println(Blockchain.get(j).public_k_e + " <<< >>> " + public_k_e);
                System.out.println(Blockchain.get(j).public_k_n + " <<< >>> " + public_k_n);
                System.out.println("Conflit : " + conflit);

            }
            // the information of the new block
            pro_hash = is.readLine();
            data = is.readLine();
            hash = is.readLine();
            proof_w = is.readLine();
            signature = is.readLine();
            public_k_e = is.readLine();
            public_k_n = is.readLine();

            show.append("Provious Hash: " + pro_hash + "\n");
            show.append("New DATA: " + data + "\n");
            show.append("Hash:  " + hash);
            show.append("Proof of Work: " + proof_w + "\n");
            show.append("The Public key (e,n):\n");
            show.append("e: " + public_k_e + "\n");
            show.append("n: " + public_k_n + "\n");
            show.append("Digital Signature: " + signature + "\n");  // 

            //2) check the hash of the new block
            // Remark: The hash is the hash of block , so, (pro_hash + data + public_k_e + public_k_n)
            if (Hash1x2x3x5(pro_hash + data + public_k_e + public_k_n + proof_w).compareTo(hash) != 0) {
                conflit = true;
                show.append("░▒▓███████►─═══════  Ｃｏｎｔｒａｄｉｃｔｉｏｎ  ═══════─◄███████▓▒░\n");
                show.append("The hash generated is different of the hash of the block.\n");
            }
            // 3) check if the hash respect the condition 
            // begin cndition:
            for (int i = 0; i < 1; i++) {  // hash begin one "0"
                if (Character.getNumericValue(hash.charAt(i)) != 0) {
                    show.append("░▒▓███████►─══════  Ｃｏｎｔｒａｄｉｃｔｉｏｎ  ═════─◄███████▓▒░\n");
                    show.append("The form of the hash does not respect the condition.\n");
                    conflit = true;
                    break;
                }
            }
            // end condition

            //4)check the signature
            BigInteger e = new BigInteger(public_k_e);
            BigInteger n = new BigInteger(public_k_n);
            // decrypt the signature by the pulic key to get the hash
            BigInteger encrypted = new BigInteger(signature, 16);
            String signature_hash = new String(encrypted.modPow(e, n).toByteArray());

            // check the hash of the block with the hash obtained from the signature
            if (hash.compareTo(signature_hash) != 0) {
                show.append("░▒▓███████►─═════  Ｃｏｎｔｒａｄｉｃｔｉｏｎ  ══════─◄███████▓▒░\n");
                show.append("There is a contradiction with the digital signature.\n");
                conflit = true;
            }

            if (conflit) {
                os.println("Manager_RES_NEGAIVE");
                os.flush();
                System.out.println("Manager_RES_NEGAIVE");

            } else {
                os.println("Manager_RES_POSITIVE");
                os.flush();
                System.out.println("Manager_RES_POSITIVE");
            }

        }

        void VTA() throws UnknownHostException, IOException {
            int c, A_max = 0, B_max, C_max;
            // Defin the ranks and their ratios
            int R_A = 80, R_B = 60, R_C = 5;
            boolean valid;
            List<Integer> cc_Managers = new ArrayList<Integer>();
            List<Integer> Rank_A = new ArrayList<Integer>();
            List<Integer> Rank_B = new ArrayList<Integer>();
            List<Integer> Rank_C = new ArrayList<Integer>();
            List<Integer> confidance = new ArrayList<Integer>();
            List<Integer> list_all_managers = new ArrayList<Integer>();

            InetAddress address = InetAddress.getLocalHost();
            Socket s1 = null;
            String line = null;
            BufferedReader br = null;
            BufferedReader is = null;
            PrintWriter os = null;

            list_all_managers = list_managers;
            System.out.println("The CF of the managers:");
            // Remove my address from the list of the managers
            for (int i = 0; i < list_managers.size(); i++) {
                if (list_managers.get(i).compareTo(MyPort) == 0) {
                    System.out.println("The manager " + list_managers.get(i) + " is removed");
                    list_managers.remove(i);
                    break;
                }
            }

            // get the cc of the managers
            for (int i = 0; i < list_managers.size(); i++) {
                ////////   Begin conection part /////////////////////////////
                s1 = new Socket(address, list_managers.get(i));
                br = new BufferedReader(new InputStreamReader(System.in));
                is = new BufferedReader(new InputStreamReader(s1.getInputStream()));
                os = new PrintWriter(s1.getOutputStream());
                ////////   End conection part /////////////////////////////
                os.println("get_cc");
                os.flush();
                cc_Managers.add(Integer.parseInt(is.readLine()));
                System.out.println("Manager " + list_managers.get(i) + " :" + cc_Managers.get(i));

                // get the max cc between all the managers
                if (cc_Managers.get(i) > A_max) {
                    A_max = cc_Managers.get(i);
                }

            }

            B_max = (60 * A_max) / 100;
            C_max = (30 * A_max) / 100;
            System.out.println("A_max: " + A_max + " - B_max: " + B_max + " - C_max: " + C_max);

            System.out.println("------- classify the ranks ----------");
            // Classify the managers
            for (int i = 0; i < list_managers.size(); i++) {
                if (cc_Managers.get(i) <= A_max && cc_Managers.get(i) > B_max) {
                    System.out.println("Rank_A: " + list_managers.get(i));
                    Rank_A.add(list_managers.get(i));
                } else if (cc_Managers.get(i) <= B_max && cc_Managers.get(i) > C_max) {
                    System.out.println("Rank_B: " + list_managers.get(i));
                    Rank_B.add(list_managers.get(i));
                } else {
                    System.out.println("Rank_C: " + list_managers.get(i));
                    Rank_C.add(list_managers.get(i));
                }
            }

            // Calculate the number of the manager of each rank.
            int NA = (R_A * Rank_A.size()) / 100;
            int NB = (R_B * Rank_B.size()) / 100;
            int NC = (R_C * Rank_C.size()) / 100;
            System.out.println("NA: " + NA + " - NB: " + NB + " - NC: " + NC);
            do {

                //fill the confidance managers
                for (int i = 0; i < NA; i++) {
                    do {
                        //int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
                        int randomNum = ThreadLocalRandom.current().nextInt(0, Rank_A.size());
                        c = Rank_A.get(randomNum);
                    } while (confidance.contains(c));
                    confidance.add(c);
                }
                for (int i = 0; i < NB; i++) {
                    do {
                        int randomNum = ThreadLocalRandom.current().nextInt(0, Rank_B.size());
                        c = Rank_B.get(randomNum);
                    } while (confidance.contains(c));
                    confidance.add(c);
                }
                for (int i = 0; i < NC; i++) {
                    do {
                        int randomNum = ThreadLocalRandom.current().nextInt(0, Rank_C.size());
                        c = Rank_C.get(randomNum);
                    } while (confidance.contains(c));
                    confidance.add(c);
                }
                System.out.println("---- List of confidance ------");

                for (int i = 0; i < NA + NB + NC; i++) {
                    System.out.print(confidance.get(i) + " | ");
                }
                System.out.println();
                // fill the address of the managers
                list_managers = new ArrayList<Integer>();
                list_managers = confidance;
                valid = validate_new_block();
                System.out.println("Return validate_new_block: " + valid);

            } while (Ratio == 50);
            if (valid) {
                Increase_Punish(true);
                list_managers = list_all_managers;
                share_block(true);
            } else {
                Increase_Punish(false);
                list_managers = list_all_managers;
                share_block(false);
            }
        }

        void Increase_Punish(boolean opt) throws UnknownHostException, IOException {
            InetAddress address = InetAddress.getLocalHost();
            Socket s1 = null;
            String line = null;
            BufferedReader br = null;
            BufferedReader is = null;
            PrintWriter os = null;

            //opt= true: increase cc of the managers which validate the block and 
            //delete their address from the Advisor the managers which rejete the block 
            //opt= false: increase cc of the managers which reject the block and 
            //delete their address from the Advisor the managers which validate the block 
            if (opt) {
                for (int i = 0; i < list_managers.size(); i++) {
                    if (Managers_accept.contains(list_managers.get(i))) {
                        ////////   Begin conection part /////////////////////////////
                        s1 = new Socket(address, list_managers.get(i));
                        br = new BufferedReader(new InputStreamReader(System.in));
                        is = new BufferedReader(new InputStreamReader(s1.getInputStream()));
                        os = new PrintWriter(s1.getOutputStream());
                        ////////   End conection part /////////////////////////////
                        os.println("Increase_cc");
                        os.flush();
                    } else {
                        ////////   Begin conection part /////////////////////////////
                        s1 = new Socket(address, Advisor_port);
                        br = new BufferedReader(new InputStreamReader(System.in));
                        is = new BufferedReader(new InputStreamReader(s1.getInputStream()));
                        os = new PrintWriter(s1.getOutputStream());
                        ////////   End conection part /////////////////////////////
                        os.println("Delete_Manager");
                        os.flush();
                        os.println(list_managers.get(i));
                        os.flush();

                        ////////   Begin conection part /////////////////////////////
                        s1 = new Socket(address, list_managers.get(i));
                        br = new BufferedReader(new InputStreamReader(System.in));
                        is = new BufferedReader(new InputStreamReader(s1.getInputStream()));
                        os = new PrintWriter(s1.getOutputStream());
                        ////////   End conection part /////////////////////////////
                        os.println("punish");
                        os.flush();
                    }
                }
            } else {
                for (int i = 0; i < list_managers.size(); i++) {
                    if (Managers_accept.contains(list_managers.get(i)) == false) {
                        ////////   Begin conection part /////////////////////////////
                        s1 = new Socket(address, list_managers.get(i));
                        br = new BufferedReader(new InputStreamReader(System.in));
                        is = new BufferedReader(new InputStreamReader(s1.getInputStream()));
                        os = new PrintWriter(s1.getOutputStream());
                        ////////   End conection part /////////////////////////////
                        os.println("Increase_cc");
                        os.flush();
                    } else {
                        s1 = new Socket(address, Advisor_port);
                        br = new BufferedReader(new InputStreamReader(System.in));
                        is = new BufferedReader(new InputStreamReader(s1.getInputStream()));
                        os = new PrintWriter(s1.getOutputStream());
                        ////////   End conection part /////////////////////////////
                        os.println("Delete_Manager");
                        os.flush();
                        os.println(list_managers.get(i));
                        os.flush();

                        ////////   Begin conection part /////////////////////////////
                        s1 = new Socket(address, list_managers.get(i));
                        br = new BufferedReader(new InputStreamReader(System.in));
                        is = new BufferedReader(new InputStreamReader(s1.getInputStream()));
                        os = new PrintWriter(s1.getOutputStream());
                        ////////   End conection part /////////////////////////////
                        os.println("punish");
                        os.flush();
                    }
                }
            }

        }
    }

    // validate_new_block: contacts all the other managers:
    boolean validate_new_block() throws IOException {
        System.out.println("------ In the validate_new_block Function ----------");
        String pro_hash, data, hash, proof_w, signature, public_k_e, public_k_n;
        boolean inf_ident = true;
        int num_manager_accept = 0;
        Managers_accept = new ArrayList<Integer>();

        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        Socket s1 = null;
        String line = null;
        BufferedReader br = null;
        BufferedReader is = null;
        PrintWriter os = null;

        // contact all managers
        System.out.println("The sizeeeeeeeeeeeeeeeeeeeeee " + list_managers.size());
        for (int i = 0; i < list_managers.size(); i++) {
            // eleminate this manager.
            if (list_managers.get(i) != MyPort) {
                //      begin connection part 
                try {
                    s1 = new Socket(address, list_managers.get(i));
                    br = new BufferedReader(new InputStreamReader(System.in));
                    is = new BufferedReader(new InputStreamReader(s1.getInputStream()));
                    os = new PrintWriter(s1.getOutputStream());
                } catch (IOException ef) {
                    ef.printStackTrace();
                    System.err.print("IO Exception");
                }

                ////////   End conection part /////////////////////////////
                // if this blockchain equals the others blockchains
                os.println("info_BC?");
                os.flush();
                // send all the Blocks
                for (int j = 0; j < Blockchain.size(); j++) {
                    os.println(Blockchain.get(j).Pro_Hash);
                    os.flush();
                    os.println(Blockchain.get(j).Data);
                    os.flush();
                    os.println(Blockchain.get(j).Hash);
                    os.flush();
                    os.println(Blockchain.get(j).Proof_w);
                    os.flush();
                    os.println(Blockchain.get(j).signature);
                    os.flush();
                    os.println(Blockchain.get(j).public_k_e.toString());
                    os.flush();
                    os.println(Blockchain.get(j).public_k_n.toString());
                    os.flush();
                }

                // receive the result from all the managers
                // for (int i = 0; i < list_managers.size()-1 ; i++) {  
                line = is.readLine(); //<<<<<<<

                if (line.compareTo("Manager_RES_POSITIVE") == 0) {
                    num_manager_accept++;
                    Managers_accept.add(list_managers.get(i));
                    System.out.println("The manager " + list_managers.get(i) + " Accept the Block");
                }
                //} fin for
            }
        }
        if (with_VTA) {
            Ratio = (num_manager_accept * 100) / (list_managers.size());
        } else {
            Ratio = (num_manager_accept * 100) / (list_managers.size() - 1);
        }

        System.out.println("The Ratio is: " + Ratio);
        if (Ratio >= 51) {
            // the bloc is accepted form 51% of the managers
            return true;
        }

        return false;
    }

    void Request_Proof_W(String DATA) {

        ////////  Start conection part /////////////////////////////
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        Socket s1 = null;
        String line = null;
        BufferedReader br = null;
        BufferedReader is = null;
        PrintWriter os = null;

        try {
            s1 = new Socket(address, MinerPort); // The port of the Miner
            br = new BufferedReader(new InputStreamReader(System.in));
            is = new BufferedReader(new InputStreamReader(s1.getInputStream()));
            os = new PrintWriter(s1.getOutputStream());
        } catch (IOException ef) {
            ef.printStackTrace();
            System.err.print("IO Exception");
        }

        ////////   End conection part /////////////////////////////
        try {

            os.println("proof_W?");
            os.flush();
            os.println(DATA);
            os.flush();
            // receive the hash and the proof of work
            HASH_DATA = is.readLine();
            PROOF_WORK = is.readLine();

        } catch (IOException ef) {
            ef.printStackTrace();
            show.append("Socket read Error\n");
        } finally {

            try {
                is.close();
                os.close();
                br.close();
                s1.close();
            } catch (IOException ex) {
                //show.append("Connection Closed");  
            }

        }

    }

    public String encrypt(String MAC, String message) {
        BigInteger e = null, N = null;
        // Search for the public key appropriete with this device
        for (int i = 0; i < list_Devices.size(); i++) {
            if (MAC.compareTo(list_Devices.get(i).MAC) == 0) {
                e = list_Devices.get(i).e;
                N = list_Devices.get(i).n;
                break;
            }
        }

        BigInteger msg = new BigInteger(message.getBytes());
        byte[] encrypted = msg.modPow(e, N).toByteArray();
        return toHex(encrypted);

    }

    public String decrypt(String MAC, String cipherText) {
        // This function is not tested yet!!!!!!!!!!!!!!!! walid

        BigInteger d = null, N = null;
        // Search for the public key appropriete with this device
        for (int i = 0; i < list_Devices.size(); i++) {
            if (MAC.compareTo(list_Devices.get(i).MAC) == 0) {
                d = list_Devices.get(i).e;
                N = list_Devices.get(i).n;
                break;
            }
        }
        BigInteger encrypted = new BigInteger(cipherText, 16);
        return new String(encrypted.modPow(d, N).toByteArray());
    }

    public String toHex(byte[] bytes) {
        BigInteger bi = new BigInteger(1, bytes);
        return String.format("%0" + (bytes.length << 1) + "X", bi);
    }

    public byte[] Degital_signature(String MAC) {

        BigInteger d = null, N = null, e = null;
        // Search for the public key appropriete with this device
        for (int i = 0; i < list_Devices.size(); i++) {
            if (MAC.compareTo(list_Devices.get(i).MAC) == 0) {
                d = list_Devices.get(i).d;
                N = list_Devices.get(i).n;
                e = list_Devices.get(i).e;
                break;
            }
        }
        // apres la sortir
        String s = bytesToString((new BigInteger(HASH_DATA.getBytes())).modPow(d, N).toByteArray());
        // verification
        String hash_sig = new String(bytesToString((new BigInteger(s.getBytes())).modPow(e, N).toByteArray()));
        return (new BigInteger(HASH_DATA.getBytes())).modPow(d, N).toByteArray();

    }

    public String bytesToString(byte[] encrypted) {
        String test = "";
        for (byte b : encrypted) {
            test += Byte.toString(b);
        }
        return test;
    }

    ////////////////    Hashage Functions   /////////////////////////
    public String Hash1x2x3x5(String input) throws NoSuchAlgorithmException {
        return SHA5(SHA3(SHA2(SHA1(input))));
    }

    public String SHA1(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.update(input.getBytes());

        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }

    public String SHA2(String input) throws NoSuchAlgorithmException {
        // SHA256
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(input.getBytes());

        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }

        return sb.toString();
    }

    public String SHA3(String input) throws NoSuchAlgorithmException {
        // SHA384 
        MessageDigest md = MessageDigest.getInstance("SHA-384");
        md.update(input.getBytes());

        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }

    public String SHA5(String input) throws NoSuchAlgorithmException {
        // SHA512

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(input.getBytes());

        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }

    public class Device_inf {

        String MAC = null;
        BigInteger e;
        BigInteger d;
        BigInteger n;
        String Password;

        public Device_inf(String MAC, BigInteger e, BigInteger d, BigInteger n, String Password) {
            this.MAC = MAC;
            this.e = e;
            this.d = d;
            this.n = n;
            this.Password = Password;
        }

    }

}
