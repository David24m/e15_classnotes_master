using System;
using System.Collections.Generic;
using System.Linq;

namespace IntroToCSharp
{
    class Program
    {
		static void Main(string[] args)
		{
			var john = new Student();
			john.Name = "John";
			john.Age = 23;
            john.Print();

			john.AgeUpdated += student_AgeUpdated;
			// add this line
			john.AgeUpdated += HappyBirthday;
			john.Age = 24;

			var students = new Student[] {
        	  new Student() { Name = "John", Age = 24 },
        	  new Student() { Name = "Fred", Age = 32 },
        	  new Student() { Name = "Barney", Age = 53 }
        	};

			Console.WriteLine("Students older than 30:");
			PrintStudents(students.Where((student) => student.Age > 30));

			Console.WriteLine("First student called John:");
			students.First((student) => student.Name == "John").Print();

            Console.WriteLine("Ages:");
            var ages = students.Select(x => x.Age).ToArray();
            Console.WriteLine(String.Join(",", ages));

            var total = students.Aggregate(0, (sum, student) => sum + student.Age);
            Console.WriteLine("Total age: {0}", total);

            var total2 = students.Sum((student) => student.Age);
            Console.WriteLine("Total age (using Sum): {0}", total2);

            var oldest = students.Max((student) => student.Age);
            Console.WriteLine("The oldest student is: {0}", oldest);

			var names = from student in students
                        where student.Age > 25
                        select student.Name;

            Console.WriteLine("Students older than 25: {0}", String.Join(",", names));
		}

		static void student_AgeUpdated(Student student)
		{
			Console.WriteLine($"{student.Name} is now {student.Age}");
		}

		static void HappyBirthday(Student student)
		{
			Console.WriteLine($"Happy birthday {student.Name}");
		}


		static void PrintStudents(IEnumerable<Student> students)
		{
			foreach (var student in students)
			{
				student.Print();
			}
		}
    }
}
