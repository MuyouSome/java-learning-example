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
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			DataOutputStream dos = new DataOutputStream(baos);
			dos.writeDouble(Math.random());
			dos.writeBoolean(false);

			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			DataInputStream dis = new DataInputStream(bais);
			System.out.println(bais.available());
			System.out.println(dis.readDouble());
			System.out.println(dis.readBoolean());

			baos.close();
			dos.close();
			bais.close();
			dis.close();
		}catch(IOException e){
			e.printStackTrace();
		}

	}
}