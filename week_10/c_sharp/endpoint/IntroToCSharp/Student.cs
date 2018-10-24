using System;
namespace IntroToCSharp
{
    delegate void AgeUpdatedDelegate(Student student);

	class Student
	{
        public event AgeUpdatedDelegate AgeUpdated;
		public int age;

		public string Name
		{
            get;
            set;
		}

		public int Age
		{
			get
			{
				return age;
			}
			set
			{
				// save the old value, because we want to call the delegate
				// once it has already been updated
				var previousValue = age;
				age = value;

				// if the new value is different from the old one,
				// and the delegate isn't null, call it
				if (previousValue != value && AgeUpdated != null)
				{
					AgeUpdated(this);
				}
			}
		}
	}
}
