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
 * @since 2016-3-2 21:40:22
 *  带缓冲区的字节流输入输出
 */
import java.io.*;

class TestBufferedStream{
	public static void main(String[] args) {
		int out= 0;
		try{
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("test.dat"));
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream("test.dat"));
			//写入数据，写入完成后要关闭(flush)，否则会读不出数据
			for (int i = 0; i<100; i++) {
				bos.write(i);
			}
			bos.close();

			while ((out = bis.read()) != -1) {
				System.out.print((char)out);
			}			
			bis.close();
		}catch(IOException e){
			System.out.println("File error!");
			System.exit(-1);
		}
	}
}