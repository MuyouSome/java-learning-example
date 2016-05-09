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
 * @since 2016-5-7 10:48:19
 *  模拟生产者消费者问题
 */



public class TestProducerConsumer{
	public static void main(String[] args) {
		ResourcePool rp = new ResourcePool();
		Producer p = new Producer(rp);
		Consumer c = new Consumer(rp);
		Thread pt = new Thread(p);
		Thread ct = new Thread(c);
		pt.start();
		ct.start();
		
	}
}

class Producer implements Runnable{
	ResourcePool rc;
	Producer( ResourcePool rc){
		this.rc = rc;
	}

	public void run(){
		for (int i =0; i<20; i++) {
			Resource re = new Resource(i);
			rc.push(re);
			System.out.println("生产了：" + re);
			try{
				Thread.sleep((int)(Math.random() * 1000));
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable{
	ResourcePool rc;
	Consumer(ResourcePool rc){
		this.rc = rc;
	}
	public void run(){
		for (int i =0; i<20; i++) {
			Resource re = rc.pop();
			System.out.println("消费了：" + re);
			try{
				Thread.sleep((int)(Math.random() * 1000));
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}

}

class Resource{
	int id;
	Resource(int id){
		this.id = id;

	}

	public String toString(){
		return "Resource " + id;
	}
}


class ResourcePool{
	int index = 0;
	Resource[] re = new Resource[6];

	public synchronized Resource pop(){
		while (0 == index) {
			try{
				this.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		this.notify();
		index--;
		return re[index];
	}

	public synchronized void push(Resource r){
		while (re.length == index) {
			try{
				this.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		this.notify();
		re[index] = r;
		index++;
	}
}