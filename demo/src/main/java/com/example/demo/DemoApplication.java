package com.example.demo;

//@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);

		ContaBancaria conta = new ContaBancaria();
		LabThread thread1 = new LabThread("thread1", conta);
		LabThread thread2 = new LabThread("thread2", conta);

		thread1.start();
		thread2.start();

	}
}

//class SharedData {
//	private int count = 0;
//
//	public int add() {
//		return ++this.count;
//	}
//}

class  ContaBancaria {
	private int saldo = 10;

	public int deposito(int valor) {
		saldo = saldo + valor;
		return saldo;
	}

	public int saque(int valor) {
		int valor_sacado;
		if (valor > saldo) {
			System.out.println("Não foi possível sacar R$ " + valor);
			valor_sacado = 0;
		} else {
			System.out.println("Saquei R$ " + valor + " de " + saldo);
//			for (int i; i < ) {
//
//			}
			valor_sacado = valor;
			saldo = saldo - valor;
		}
		return valor_sacado;

	}
}

class LabThread implements Runnable {

	private Thread labThread;
	private String name;
	private int delay;

//	private SharedData data;

	private ContaBancaria conta;

	public LabThread(String name, ContaBancaria conta) {
		this.name = name;
		this.delay = 200;
		this.conta = conta;
	}

	@Override
	public void run() {
		System.out.println("Thread em execução: " + name);
		for (int i = 0; i < 8; i++) {
//			System.out.println(data.add() + " " + name);
			conta.saque(1);
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void start() {
		System.out.println("Thread " + name + " começou!");

		if (labThread == null) {
			labThread = new Thread(this, name);
			labThread.start();
		}
	}
}
