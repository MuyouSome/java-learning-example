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
 * @since 2016-2-29 07:40:02
 *  字节流输入
 */

import java.io.*;

class TestFileInputStream{
	public static void main(String[] args) {
		FileInputStream in = null;
		try{
			// “\\”代表Windows分隔符，Linux下用“/”，或用File.separator
			in = new FileInputStream("E:\\git\\java-learning-example\\src\\IO\\TestFileInputStream.java");
		}catch(FileNotFoundException e){
			System.out.println("File not found!");
			System.exit(-1);
		}

		try{
			long num = 0;
			int b = 0;
			while ((b = in.read()) != -1) {
				System.out.print((char)b);
				num++;
			}
			in.close();
			System.out.println();
			System.out.println("Size:" + num);

		}catch(IOException e){
			System.out.println("Read file error!");
			System.exit(-1);
		}
	}
}