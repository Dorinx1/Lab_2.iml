public class ThreadGroup1 {
        public static void main(String[] args) {
        ThreadGroup sys = Thread.currentThread().getThreadGroup();
        sys.list();
        sys.setMaxPriority(Thread.MAX_PRIORITY - 1);//Setam prioritatea grupuilui
        Thread curr = Thread.currentThread();
        curr.setPriority(curr.getPriority() + 1);
        sys.list();
        Thread Th1 = new Thread("Th1");
        Th1.setPriority(Thread.MAX_PRIORITY - 7);
        sys.list();
        Thread Th2 = new Thread("Th2");
        Th2.setPriority(Thread.MAX_PRIORITY - 7);
        sys.list();

        ////////// - Setam pentru intai -> G2 {
        ThreadGroup G2 = new ThreadGroup("G2");
        G2.setMaxPriority(Thread.MAX_PRIORITY);
        Thread th1 = new Thread(G2, "Th1");
        th1.setPriority(Thread.MAX_PRIORITY - 4);
        G2.list();
        Thread th2 = new Thread(G2, "Th2");
        th2.setPriority(Thread.MAX_PRIORITY - 5);
        G2.list();
        Thread th3 = new Thread(G2, "Th3");
        th3.setPriority(Thread.MAX_PRIORITY - 5);
        G2.list();

        G2.setMaxPriority(Thread.MAX_PRIORITY - 1);
        G2.setMaxPriority(Thread.MAX_PRIORITY);
        G2.list();
        //  -> G2    }

        ///////// - apoi setam -> G1 {
        ThreadGroup G1 = new ThreadGroup("G1");//thread
        G1.setMaxPriority(Thread.MAX_PRIORITY);
        Thread tA = new Thread(G1, "ThA");//Firul de executie al G1
        tA.setPriority(Thread.MAX_PRIORITY - 3);
        G1.list();  //includem in lista thread

        G1.setMaxPriority(Thread.MAX_PRIORITY - 2);//Setam prioritatea Grupului
        G1.setMaxPriority(Thread.MAX_PRIORITY);
        G1.list();
        ////  -> G1 }

        /////// La sfarsit am -> G3 {
        ThreadGroup G3 = new ThreadGroup("G3");
        G3.setMaxPriority(Thread.MAX_PRIORITY);
        Thread ta = new Thread(G3, "Tha");//Firul de executie al G3
        ta.setPriority(Thread.MAX_PRIORITY-3);
        G3.list();
        Thread tb = new Thread(G3, "Thb");//Firul de executie al G3
        tb.setPriority(Thread.MAX_PRIORITY-3);
        G3.list();
        Thread tc = new Thread(G3, "Thc");//Firul de executie al G3
        tc.setPriority(Thread.MAX_PRIORITY-3);
        G3.list();
        Thread td = new Thread(G3, "Thd");//Firul de executie al G3
        td.setPriority(Thread.MAX_PRIORITY -3);
        G3.list();

        G3.setMaxPriority(Thread.MAX_PRIORITY - 3);//Setam prioritatea Grupului G3
        G3.setMaxPriority(Thread.MAX_PRIORITY);
        G3.list();
        ////////////  -> G3
        }
} ///:~

//Main{G1{
//     G3{Tha(3), Thb(3), Thc(3), Thd(3)},
//     ThA(3)}
//    ,G2{Th1(4), Th2(5), Th3(5)}
//    ,Th1(7), Th2(7)}