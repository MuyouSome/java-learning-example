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
 * @since 2016-4-4 12:24:32
 *  线程sleep()、interrupt()方法
 */

import java.util.*;

public class TestInterrupt{
	public static void main(String[] args) {
		Thread th = new Thread(new myThread());
		th.start();
		try{
			th.sleep(10000);
		}catch(InterruptedException e){
			return;
		}
		th.interrupt();
		
	}
}


class myThread implements Runnable{
	public void run(){
		while (true) {
			System.out.println(new Date());
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				return;
			}
		}
	}
}