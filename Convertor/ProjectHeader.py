class Centimeters:
    def __init__(self, unit):
        self.Unit = unit
    def ToMeters(self):
        return int(self.Unit) / 100
    def ToMillimeters(self):
        return int(self.Unit) * 10
    def ToKilometers(self):
        return int(self.Unit) / 100000
    def ToYards(self):
        return self.Unit * 0.0109361
    def ToFeets(self):
        return self.Unit * 0.0328084
    def ToInches(self):
        return self.Unit * 0.393701
    def print(self):
        print("Unit", self.Unit)
        
class Millimeters:
    def __init__(self, unit):
        self.Unit = unit
    def ToMeters(self):
        return int(self.Unit) / 1000
    def ToCentimeters(self):
        return int(self.Unit) / 10
    def ToKilometers(self):
        return int(self.Unit) / 1000000
    def ToYards(self):
        return self.Unit * 0.00109361
    def ToFeets(self):
        return self.Unit * 0.00328084
    def ToInches(self):
        return self.Unit * 0.0393701
    def print(self):
        print("Unit", self.Unit)

class Meters:
    def __init__(self, unit):
        self.Unit = unit
    def ToCentimeters(self):
        return int(self.Unit) * 100
    def ToMillimeters(self):
        return int(self.Unit) * 1000
    def ToKilometers(self):
        return int(self.Unit) / 1000
    def ToYards(self):
        return self.Unit * 1.09361
    def ToFeets(self):
        return self.Unit * 3.28084
    def ToInches(self):
        return self.Unit * 39.3701
    def print(self):
        print("Unit", self.Unit)

class Kilometers:
    def __init__(self, unit):
        self.Unit = unit
    def ToCentimeters(self):
        return int(self.Unit) * 100000
    def ToMillimeters(self):
        return int(self.Unit) * 1000000
    def ToMeters(self):
        return int(self.Unit) * 1000
    def ToYards(self):
        return self.Unit * 1093.61
    def ToFeets(self):
        return self.Unit * 3280.84
    def ToInches(self):
        return self.Unit * 39370.1
    def print(self):
        print("Unit", self.Unit)

class Yards:
    def __init__(self, unit):
        self.Unit = unit
    def ToCentimeters(self):
        return self.Unit * 91.44
    def ToMillimeters(self):
        return self.Unit * 914.4
    def ToMeters(self):
        return self.Unit * 0.9144
    def ToKilometers(self):
        return self.Unit * 0.0009144
    def ToFeets(self):
        return self.Unit * 3
    def ToInches(self):
        return self.Unit * 36
    def print(self):
        print("Unit", self.Unit)

class Feets:
    def __init__(self, unit):
        self.Unit = unit
    def ToCentimeters(self):
        return self.Unit * 30.48
    def ToMillimeters(self):
        return self.Unit * 304.8
    def ToMeters(self):
        return self.Unit * 0.3048
    def ToYards(self):
        return self.Unit * 0.333333
    def ToKilometers(self):
        return self.Unit * 0.0003048
    def ToInches(self):
        return self.Unit * 12
    def print(self):
        print("Unit", self.Unit)

class Inches:
    def __init__(self, unit):
        self.Unit = unit
    def ToCentimeters(self):
        return self.Unit * 2.54
    def ToMillimeters(self):
        return self.Unit * 25.4
    def ToMeters(self):
        return self.Unit * 0.0254
    def ToYards(self):
        return self.Unit * 0.0277778
    def ToFeets(self):
        return self.Unit * 0.0833333
    def ToKilometers(self):
        return self.Unit * 0.0000254
    def print(self):
        print("Unit", self.Unit)


