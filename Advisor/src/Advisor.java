
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ESE : elgharbi salah eddine
 */





public class Advisor extends javax.swing.JFrame {


    static boolean with_VTA = true;
    static List<String> list_Managers = new ArrayList<String>();
    static List<Block> Blockchain;
    static String Man_address; // addrees of manager
    static boolean get_domin_BC;

    public Advisor() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        show = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setFocusTraversalPolicyProvider(true);
        setLocation(new java.awt.Point(200, 100));

        jButton1.setBackground(new java.awt.Color(245, 250, 250));
        jButton1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(90, 10, 90));
        jButton1.setText("Start Listen");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setText("< Advisor >");

        show.setColumns(20);
        show.setRows(5);
        jScrollPane2.setViewportView(show);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Logs (VM) :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(241, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(222, 222, 222))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        show.append("Advisor is started......\n");
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
            java.util.logging.Logger.getLogger(Advisor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Advisor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Advisor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Advisor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Advisor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea show;
    // End of variables declaration//GEN-END:variables

//********************************************************* */
    public class show_info extends Thread {

        public void run() {
            Socket s = null;
            ServerSocket ss2 = null;

            try {
                ss2 = new ServerSocket(5000); // can also use static final PORT_NUM , when defined

            } catch (IOException e) {
                e.printStackTrace();
                show.append("Server error\n");

            }

            while (true) {
                try {
                    // start the function of the server
                    s = ss2.accept();
                    // show.append("connection Established");

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

                if (line.compareTo("MyAddress") == 0) {
                    // record its address and give it the dominant BC
                    New_Manager();
                } else if (line.compareTo("get_manag_addr") == 0) {
                    // send all the address of the managers
                    send_managers_address();
                } else if (line.compareTo("Delete_Manager") == 0) {
                    String m = is.readLine().toString();
                    list_Managers.remove(m);
                    show.append("The Manager which is referenced by: " + m + " is Deleted\n");
                }

            } catch (IOException e) {

                line = this.getName(); //reused String line for getting thread name
                show.append("IO Error/ Client " + line + " terminated abruptly\n");
            } catch (NullPointerException e) {
                line = this.getName(); //reused String line for getting thread name
                show.append("Client " + line + " Closed\n");
            } finally {
                try {
                    //show.append("Connection Closing..");
                    if (is != null) {
                        is.close();
                        //show.append(" Socket Input Stream Closed");
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
                    show.append("Socket Close Error\n");
                }
            }
        }

        // send all the address of the managers
        void send_managers_address() {
            //send the size of the list
            os.println(list_Managers.size());
            os.flush();
            //send all the address of the managers
            for (int i = 0; i < list_Managers.size(); i++) {
                os.println(list_Managers.get(i));
                os.flush();
            }
        }

        // record its address and give it the dominant BC
        public void New_Manager() throws IOException {
            boolean res;
            // fill the address of the managers.
            Man_address = is.readLine();
            list_Managers.add(Man_address);
            show.append("The manager referenced by " + Man_address + " is connected\n");
            System.out.println();

            // >>>>>>>>>>>>  afiiiichage brk
            for (int i = 0; i < list_Managers.size(); i++) {
                System.out.print(" ||| " + list_Managers.get(i));
            }
            System.out.println();

            // give it the BC.
            if (list_Managers.size() > 1) {   // min 2 
                // pass by all the managers to get the dominant BC

                if (with_VTA) {
                    res = select_dominant_BC();

                } else {
                    res = get_dominant_BC_Without_VTA();
                }

                if (res) {
                    // send the dominant BC to the new manager.
                    os.println("send_BC");
                    os.flush();
                    os.println(Blockchain.size());
                    os.flush();
                    for (int k = 0; k < Blockchain.size(); k++) {
                        os.println(Blockchain.get(k).Pro_Hash);
                        os.flush();
                        os.println(Blockchain.get(k).Data);
                        os.flush();
                        os.println(Blockchain.get(k).Hash);
                        os.flush();
                        os.println(Blockchain.get(k).Proof_w);
                        os.flush();
                        os.println(Blockchain.get(k).public_k_e.toString());
                        os.flush();
                        os.println(Blockchain.get(k).public_k_n.toString());
                        os.flush();
                        os.println(Blockchain.get(k).signature);
                        os.flush();
                    }
                } else {
                    os.println("Network_damaged");
                    os.flush();
                }

            } else {
                os.println("Not_send_BC");
                os.flush();
            }

            for (int i = 0; i < list_Managers.size(); i++) {
                System.out.println(" || " + list_Managers.get(i));
            }
        }

        public boolean get_dominant_BC(List<Integer> confidance) throws IOException {
            System.out.println("----- In the get_dominant_BC ------");
            Blockchain = new ArrayList<Block>();
            InetAddress address = null;
            try {
                address = InetAddress.getLocalHost();
            } catch (UnknownHostException ex) {
                Logger.getLogger(Advisor.class.getName()).log(Level.SEVERE, null, ex);
            }
            Socket s1 = null;
            String line = null;
            BufferedReader br = null;
            BufferedReader is = null;
            PrintWriter os = null;
            // contact all managers
            for (int i = 0; i < confidance.size(); i++) {    // confidence =  address
                // eleminate this manager.
                if (confidance.get(i) != Integer.parseInt(Man_address)) {

                    //      begin connection part 
                    try {
                        s1 = new Socket(address, confidance.get(i));
                        br = new BufferedReader(new InputStreamReader(System.in));
                        is = new BufferedReader(new InputStreamReader(s1.getInputStream()));
                        os = new PrintWriter(s1.getOutputStream());
                    } catch (IOException ef) {
                        ef.printStackTrace();
                        System.err.print("IO Exception");
                    }
                    ////////   End conection part /////////////////////////////

                    // get the BC.
                    os.println("give_BC");
                    os.flush();

                    // get the size of the BC
                    int sizeBC = Integer.parseInt(is.readLine());

                    for (int k = 0; k < sizeBC; k++) {

                        Blockchain.add(new Block(is.readLine(), is.readLine(), is.readLine(), is.readLine(),
                                new BigInteger(is.readLine()), new BigInteger(is.readLine()), is.readLine()));
                    }

                    int count_identic = 0;
                    boolean contradiction = false;

                    // contact the other managers
                    for (int j = 0; j < confidance.size(); j++) {
                        // eleminate this manager.
                        if (confidance.get(i) != Integer.parseInt(Man_address)) {
                            //&& list_Managers.get(j).compareTo(list_Managers.get(i)) != 0) {
                            //      begin connection part 
                            try {
                                s1 = new Socket(address, confidance.get(i));
                                br = new BufferedReader(new InputStreamReader(System.in));
                                is = new BufferedReader(new InputStreamReader(s1.getInputStream()));
                                os = new PrintWriter(s1.getOutputStream());
                            } catch (IOException ef) {
                                ef.printStackTrace();
                                System.err.print("IO Exception");
                            }
                            ////////   End conection part /////////////////////////////

                            // get the BC.
                            os.println("give_BC");
                            os.flush();

                            // get the size of the BC
                            sizeBC = Integer.parseInt(is.readLine());

                            for (int k = 0; k < sizeBC; k++) {
                                if (Blockchain.get(k).Pro_Hash.compareTo(is.readLine()) != 0
                                        || Blockchain.get(k).Data.compareTo(is.readLine()) != 0
                                        || Blockchain.get(k).Hash.compareTo(is.readLine()) != 0
                                        || Blockchain.get(k).Proof_w.compareTo(is.readLine()) != 0
                                        || Blockchain.get(k).public_k_e.toString().compareTo(is.readLine()) != 0
                                        || Blockchain.get(k).public_k_n.toString().compareTo(is.readLine()) != 0
                                        || Blockchain.get(k).signature.compareTo(is.readLine()) != 0) {
                                    contradiction = true;
                                }
                                break;
                            }
                            if (contradiction == false) {
                                count_identic++;

                            }
                            if (count_identic * 100 / confidance.size() > 50) {

                                return true;
                            }
                        }
                    }

                }
            }

            return false;
        }

        public boolean get_dominant_BC_Without_VTA() throws IOException {
            System.out.println("----- In the get_dominant_BC ------");
            Blockchain = new ArrayList<Block>();
            InetAddress address = null;
            try {
                address = InetAddress.getLocalHost();
            } catch (UnknownHostException ex) {
                Logger.getLogger(Advisor.class.getName()).log(Level.SEVERE, null, ex);
            }
            Socket s1 = null;
            String line = null;
            BufferedReader br = null;
            BufferedReader is = null;
            PrintWriter os = null;
            // contact all managers
            for (int i = 0; i < list_Managers.size(); i++) {
                // eleminate this manager.
                if (list_Managers.get(i).compareTo(Man_address) != 0) {

                    //      begin connection part 
                    try {
                        s1 = new Socket(address, Integer.parseInt(list_Managers.get(i)));
                        br = new BufferedReader(new InputStreamReader(System.in));
                        is = new BufferedReader(new InputStreamReader(s1.getInputStream()));
                        os = new PrintWriter(s1.getOutputStream());
                    } catch (IOException ef) {
                        ef.printStackTrace();
                        System.err.print("IO Exception");
                    }
                    ////////   End conection part /////////////////////////////

                    // get the BC.
                    os.println("give_BC");
                    os.flush();

                    // get the size of the BC
                    int sizeBC = Integer.parseInt(is.readLine());

                    for (int k = 0; k < sizeBC; k++) {

                        Blockchain.add(new Block(is.readLine(), is.readLine(), is.readLine(), is.readLine(),
                                new BigInteger(is.readLine()), new BigInteger(is.readLine()), is.readLine()));
                    }

                    int count_identic = 0;
                    boolean contradiction = false;

                    // contact the other managers
                    for (int j = 0; j < list_Managers.size(); j++) {
                        // eleminate this manager.
                        if (list_Managers.get(i).compareTo(Man_address) != 0) {
                            //&& list_Managers.get(j).compareTo(list_Managers.get(i)) != 0) {
                            //      begin connection part 
                            try {
                                s1 = new Socket(address, Integer.parseInt(list_Managers.get(i)));
                                br = new BufferedReader(new InputStreamReader(System.in));
                                is = new BufferedReader(new InputStreamReader(s1.getInputStream()));
                                os = new PrintWriter(s1.getOutputStream());
                            } catch (IOException ef) {
                                ef.printStackTrace();
                                System.err.print("IO Exception");
                            }
                            ////////   End conection part /////////////////////////////

                            // get the BC.
                            os.println("give_BC");
                            os.flush();

                            // get the size of the BC
                            sizeBC = Integer.parseInt(is.readLine());

                            for (int k = 0; k < sizeBC; k++) {
                                if (Blockchain.get(k).Pro_Hash.compareTo(is.readLine()) != 0
                                        || Blockchain.get(k).Data.compareTo(is.readLine()) != 0
                                        || Blockchain.get(k).Hash.compareTo(is.readLine()) != 0
                                        || Blockchain.get(k).Proof_w.compareTo(is.readLine()) != 0
                                        || Blockchain.get(k).public_k_e.toString().compareTo(is.readLine()) != 0
                                        || Blockchain.get(k).public_k_n.toString().compareTo(is.readLine()) != 0
                                        || Blockchain.get(k).signature.compareTo(is.readLine()) != 0) {
                                    contradiction = true;
                                }
                                break;
                            }
                            if (contradiction == false) {
                                count_identic++;
                            }
                            if (count_identic * 100 / list_Managers.size() > 50) {

                                return true;
                            }
                        }
                    }

                }
            }

            return false;

        }

        boolean select_dominant_BC() throws UnknownHostException, IOException {
            System.out.println("----- In the select_dominant_BC ------");
            int c, A_max = 0, B_max, C_max;
            // Defin the ranks and their ratios
            int R_A = 80, R_B = 60, R_C = 5;
            boolean valid;
            List<Integer> cc_Managers = new ArrayList<Integer>();   // cc_Managers I MEANS Confidance factor > CF 
            List<Integer> Rank_A = new ArrayList<Integer>();
            List<Integer> Rank_B = new ArrayList<Integer>();
            List<Integer> Rank_C = new ArrayList<Integer>();
            // confidance is the list of the managers that will apply the VTA
            List<Integer> confidance = new ArrayList<Integer>();
            List<String> list_other_managers = new ArrayList<String>();

            InetAddress address = InetAddress.getLocalHost();
            Socket s1 = null;
            String line = null;
            BufferedReader br = null;
            BufferedReader is = null;
            PrintWriter os = null;

            System.out.println();
            for (int i = 0; i < list_Managers.size(); i++) {
                System.out.print(" |||| " + list_Managers.get(i));
            }
            System.out.println();

            for (int i = 0; i < list_Managers.size(); i++) {
                list_other_managers.add(list_Managers.get(i));
            }

            System.out.println();
            for (int i = 0; i < list_Managers.size(); i++) {
                System.out.print(" ||||| " + list_Managers.get(i));
            }
            System.out.println();
            for (int i = 0; i < list_other_managers.size(); i++) {
                if (list_other_managers.get(i).compareTo(Man_address) == 0) {
                    System.out.println("The manager " + list_other_managers.get(i) + " is removed");
                    list_other_managers.remove(i);
                    break;
                }
// list_other_managers brek mafihch hadak new manager bch nbdaaa nkhdem biha w mneha nkhyer list diik t3 confidence !
            }

            System.out.println("List other manager:");
            for (int i = 0; i < list_other_managers.size(); i++) {
                System.out.print(" | " + list_other_managers.get(i));
            }
            System.out.println();

            System.out.println("List managers:");
            for (int i = 0; i < list_Managers.size(); i++) {
                System.out.print(" | " + list_Managers.get(i));
            }
            System.out.println();

            System.out.println("The CF of the managers:");
            for (int i = 0; i < list_other_managers.size(); i++) {
                ////////   Begin conection part /////////////////////////////
                s1 = new Socket(address, Integer.parseInt(list_other_managers.get(i)));
                br = new BufferedReader(new InputStreamReader(System.in));
                is = new BufferedReader(new InputStreamReader(s1.getInputStream()));
                os = new PrintWriter(s1.getOutputStream());
                ////////   End conection part /////////////////////////////
                os.println("get_cc");
                os.flush();
                cc_Managers.add(Integer.parseInt(is.readLine()));
                System.out.println("Manager " + list_other_managers.get(i) + " :" + cc_Managers.get(i));

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
            for (int i = 0; i < list_other_managers.size(); i++) {
                if (cc_Managers.get(i) <= A_max && cc_Managers.get(i) > B_max) {
                    System.out.println("Rank_A: " + list_other_managers.get(i));
                    Rank_A.add(Integer.parseInt(list_other_managers.get(i)));
                } else if (cc_Managers.get(i) <= B_max && cc_Managers.get(i) > C_max) {
                    System.out.println("Rank_B: " + Integer.parseInt(list_other_managers.get(i)));
                    Rank_B.add(Integer.parseInt(list_other_managers.get(i)));
                } else {
                    System.out.println("Rank_C: " + list_other_managers.get(i));
                    Rank_C.add(Integer.parseInt(list_other_managers.get(i)));
                }
            }

            // Calculate the number of the manager of each rank.
            int NA = (R_A * Rank_A.size()) / 100;
            int NB = (R_B * Rank_B.size()) / 100;
            int NC = (R_C * Rank_C.size()) / 100;
            
            // in the case whene the network has one manager (the first manager)
            if (NA == 0 && NB == 0 && NC == 0 && Rank_A.size() > 0) {
                NA = 1;
            }
            System.out.println("NA: " + NA + " - NB: " + NB + " - NC: " + NC);

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
            return get_dominant_BC(confidance);

        }

    }

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

}
