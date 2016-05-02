/* Copyright [2016] [Will Shen]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author muyousome
 * @since  2016-5-1 19:38:54
 *  线程同步
 */


public class TestThreadSync implements Runnable {
	TestTimer timer = new TestTimer();
	public static void main(String[] args) {
		TestThreadSync tts = new TestThreadSync();
		Thread t1 = new Thread(tts);
		Thread t2 = new Thread(tts);
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();
	}

	public void run(){
		timer.add(Thread.currentThread().getName());
	}
}

class TestTimer{
	private static int count = 0;
	public synchronized void add(String name){
		count++;
		try{
			Thread.sleep(1);
		}catch(InterruptedException e){
			System.out.println(name + "，你是第" + count + "个使用timer的线程");
		}
	}
}