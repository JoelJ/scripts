public class ThreadDump {
    public static void threadDump() {
		Set<Thread> threads = Thread.getAllStackTraces().keySet();
		if(!threads.isEmpty()) {
			synchronized (System.err) {
				System.err.println("vvvvvvvvvvvvvvvvvvvvvv");
				System.err.println("vv Full Thread Dump vv");
				System.err.println("vvvvvvvvvvvvvvvvvvvvvv");
				for(Thread thread : threads) {
					printThreadStackTrace(thread);
				}
				System.err.println("^^^^^^^^^^^^^^^^^^^^^^");
				System.err.println("^^^^^^^^^^^^^^^^^^^^^^");
				System.err.println("^^^^^^^^^^^^^^^^^^^^^^");
			}
		}
	}
}
