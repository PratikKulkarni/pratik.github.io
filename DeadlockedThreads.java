

class Resource1{
	synchronized void method1(Resource2 r2){
		String name=Thread.currentThread().getName();
		System.out.println(name + " entered method1 of Resource1");
		try{
			Thread.sleep(1000);
		}
		catch(Exception e){
			System.out.println("Resource1 thread interrupted");
		}

		System.out.println(name+" trying to call method2 of Resource2");
		r2.method2();
	}

	synchronized void method2(){
		String name1=Thread.currentThread().getName();
		System.out.println(name1+" has entered method 2 of Resource1");
	}
}

class Resource2{
	synchronized void method1(Resource3 r3){
		String name=Thread.currentThread().getName();
		System.out.println(name + " entered method1 of Resource2");
		try{
			Thread.sleep(1000);
		}
		catch(Exception e){
			System.out.println("Resource2 thread interrupted");
		}

		System.out.println(name+" trying to call method2 of Resource3");
		r3.method2();
	}

	synchronized void method2(){
		String name1=Thread.currentThread().getName();
		System.out.println(name1+" has entered method 2 of Resource2");
	}
}


class Resource3{
	synchronized void method1(Resource4 r4){
		String name=Thread.currentThread().getName();
		System.out.println(name + " entered method1 of Resource3");
		try{
			Thread.sleep(1000);
		}
		catch(Exception e){
			System.out.println("Resource3 thread interrupted");
		}

		System.out.println(name+" trying to call method2 of Resource4");
		r4.method2();
	}

	synchronized void method2(){
		String name1=Thread.currentThread().getName();
		System.out.println(name1+" has entered method 2 of Resource3");
	}
}


class Resource4{
	synchronized void method1(Resource1 r1){
		String name=Thread.currentThread().getName();
		System.out.println(name + " entered method1 of Resource4");
		try{
			Thread.sleep(1000);
		}
		catch(Exception e){
			System.out.println("Resource4 thread interrupted");
		}

		System.out.println(name+" trying to call method2 of Resource1");
		r1.method2();
	}

	synchronized void method2(){
		String name1=Thread.currentThread().getName();
		System.out.println(name1+" has entered method 2 of Resource4");
	}
}




class DeadlockedThreads implements Runnable{

	Resource1 r1=new Resource1();
	Resource2 r2=new Resource2();
	Resource3 r3=new Resource3();
	Resource4 r4=new Resource4();
	Thread t1,t2,t3,t4;
	DeadlockedThreads(){
		t1=new Thread(this,"Thread1");
		t2=new Thread(this,"Thread2");
		t3=new Thread(this,"Thread3");
		t4=new Thread(this,"Thread4");
	}

	public void run(){
		String name=Thread.currentThread().getName();
		if(name.equals("Thread1"))
			r1.method1(r2);
		else if(name.equals("Thread2"))
			r2.method1(r3);
		else if(name.equals("Thread3"))
			r3.method1(r4);
		else
			r4.method1(r1);
	} 
	public static void main(String[] args){
		DeadlockedThreads obj=new DeadlockedThreads();
		obj.t1.start();
		obj.t2.start();
		obj.t3.start();
		obj.t4.start();
		try{
		obj.t1.join();
		obj.t2.join();
		obj.t3.join();
		obj.t4.join();
		}
		catch(InterruptedException e){
			System.out.println("Thread Interrupted");
		}
	}
}