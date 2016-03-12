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
 * @since 2016-3-12 10:45:18
 *  Print流
 */

import java.io.*;

class TestPrint{
	public static void main(String[] args) {
		PrintStream ps = null;
		int ln = 0;
		try{
			FileOutputStream fos = new FileOutputStream("test.txt");
			ps = new PrintStream(fos);
		}
		catch(IOException e){
			e.printStackTrace();
		}

		if(ps != null){
			System.setOut(ps);
		}

		for (char c = 0; c <= 6000; c++) {
			System.out.print(c + " ");

			//每100个字符换行
			if (ln++ >= 10) {
				System.out.println();
				ln = 0;
			}
		}
	}
}