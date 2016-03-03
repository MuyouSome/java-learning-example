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
 * @since 2016-3-3 21:44:53
 *  转换流的使用和编码
 */

import java.io.*;

class TestStreamReaderWriter{
	public static void main(String[] args) {
		try{

			//新建文件，用转换流写入数据
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("test.txt"));

			osw.write("TestStreamReaderWriter");

			System.out.println(osw.getEncoding());

			osw.close();

			//将命令行的输入，添加到文件末尾
			osw = new OutputStreamWriter(new FileOutputStream("test.txt", true), "GBK");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			osw.write(" " + br.readLine());

			System.out.println(osw.getEncoding());

			br.close();

			osw.close();
			

		}catch(IOException e){
			e.printStackTrace();
		}
	}
}