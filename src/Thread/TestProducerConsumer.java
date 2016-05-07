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
 *  模拟线生产者消费者问题
 */



public class TestProducerConsumer{
	public static void main(String[] args) {
		
	}
}

class Producer implements Runnable{
	ResourcePool rc;
	Producer( ResourcePool rc){
		this.rc = rc;
	}

}

class Consumer implements Runnable{
	Consumer(){

	}


}

class Resource{
	int id;
	Resource(int id){
		this.id = id;

	}

}


class ResourcePool{
	int index = 0;
	Resource[] re = new Resource[6];

	public synchronized Resource pop(){
		index--;
		return re[index];
	}

	public synchronized void push(Resource r){
		re[index] = r;
		index++;
	}
}