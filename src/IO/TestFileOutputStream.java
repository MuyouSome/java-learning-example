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
 * @since 2016-2-29 21:03:38
 *  字节流输入输出
 */

import java.io.*;


class TestFileOutputStream{
	public static void main(String[] args) {
		FileInputStream in = null;
		FileOutputStream out = null;
		String path = "." + File.separator;
		int b = 0;
		try{
			in = new FileInputStream(path + "TestFileOutputStream.java");
			out = new FileOutputStream(path + "OutputFile.java");

			//从文件中读取字节流写入新文件中
			while((b = in.read()) != -1){
				out.write(b);
			}
			in.close();
			out.close();

		}catch(FileNotFoundException e1){
			System.out.println("File not found!");
			System.exit(-1);
		}catch(IOException e2){
			System.out.println("Read file error!");
			System.exit(-1);
		}
	}
}