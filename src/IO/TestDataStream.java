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
 * @since 2016-3-4 08:14:27
 *  数据流(DataStream)输入输出
 */

import java.io.*;

class TestDataStream{
	public static void main(String[] args) {
		try{

			//新建字节数组且关联输出流
			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			//新建数据流，嵌套在字节数组流上
			DataOutputStream dos = new DataOutputStream(baos);

			//通过数据流向字节数组写入数据
			dos.writeDouble(Math.random());
			dos.writeBoolean(false);

			//新建字节数组输入流，关联已存在的字节数组
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());

			//新建数据输入流，嵌套在字节数组输入流上
			DataInputStream dis = new DataInputStream(bais);


			//可读取的数据
			System.out.println(bais.available());
			
			//从字节数组读取数据且通过数据流转换
			System.out.println(dis.readDouble());
			System.out.println(dis.readBoolean());

			//释放资源
			baos.close();
			dos.close();
			bais.close();
			dis.close();

		}catch(IOException e){
			e.printStackTrace();
		}

	}
}