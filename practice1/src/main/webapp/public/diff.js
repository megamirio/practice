function Person(first, last, age, eyecolor) {
    this.firstName = first;
    this.lastName = last;
    this.age = age;
    this.eyeColor = eyecolor;

    this.nationality = "English";
    this.name = function () {
        return this.firstName + " " + this.lastName;
    };
}

var myFather = new Person("John", "Doe", 50, "blue");

Person.prototype.nationality = "English22";

Person.prototype.name2 = function() {
    return this.firstName + " " + this.lastName + " other;";
};

function getValue() {
    return "one two three";
}