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
 * @since 2016-02-15 19:10:00
 *  继承以及重写方法
 */

class Person {
	private String name;
	private String location;

 	Person(String name){
 		this.name = name;
 		this.location = "Beijing";
 	}

 	Person(String name, String location){
 		this.name = name;
 		this.location = location;
 	}

 	public String getInfo(){
 		return "name:" + this.name + " location:" + this.location;
 	}
}

class Student extends Person{
	private String school;

	Student(String name, String school){
		this(name, school, "Bei");
	}

	Student (String name, String location, String school){
		super(name, location);
		this.school = school;
	}

	public String getInfo(){
		return super.getInfo() + " school:" + this.school;
	}
}

public class TestPerson{
	public static void main(String[] args) {
		Person p1 = new Person("Shen");
		Person p2 = new Person("Shen", "Shanghai");

		Student s1 = new Student("Will", "WHU");
		Student s2 = new Student("Will", "Shanghai", "Fudan");

		System.out.println(p1.getInfo());
		System.out.println(p2.getInfo());
		System.out.println(s1.getInfo());
		System.out.println(s2.getInfo());
	}
}