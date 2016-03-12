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
 * @since 2016-3-12 13:53:23
 *  Object流和Serializable标记接口
 */

import java.io.*;

public class TestObjectIO{
	public static void main(String[] args) {
		TestSer t = new TestSer();
		t.i = 888;

		String path = "./test.txt";
		try{
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(t);
			fos.close();
			oos.close();

			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);

			TestSer ts = (TestSer)ois.readObject();
			System.out.println("i:" + ts.i + " j:" + ts.j + " k:" + ts.k + " s:" + ts.s);

			fis.close();
			ois.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		//ois.readObject()会抛出ClassNotFoundException
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}

class TestSer implements Serializable{
	int i = 10;
	float j = 1.2f;
	double k = 71.2;
	String s = "TestSer";
}