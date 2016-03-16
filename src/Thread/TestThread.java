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
 * @since 2016-3-16 23:00:51
 *  线程基本概念：一般函数调用和启动线程的区别
 */

public class TestThread{
	public static void main(String[] args) {
		Runner r = new Runner();
		//r.run();
		Thread t = new Thread(r);
		t.start();

		for (int i = 0; i < 100; i++) {
			System.out.println("Main Thread---" + i);
		}

	}
}


class Runner implements Runnable {
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Sub Thread---" + i);
		}
	}	
}