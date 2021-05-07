# Association, Composition, Aggregation

* In Object oriented programming, one object is related to other object 
in order to use functionality/service provided by other object. This relation
between two object is called Association. In simple terms objects are associated
with each other in order to achieve some functionality. Composition and Aggregation
are the type of Association.

* Association is called Composition when one object **owns** the other object. 
for example Human and Body parts (Heart, Hand, Eyes etc). Human owns body parts,
without Human object body parts does not meaningfully exists. There is strong 
relationship between objects.

* Association is called Aggregation when objects can exists without ownership. 
There is no strong relationship between object, instead independent. 
For example Employee and Company. Both are independent. Company has employees and if 
Company is shut down in future, Employee can exist and may join other Company.

* Composition is strong type of relation while Aggregation not.