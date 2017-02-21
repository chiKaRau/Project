from tkinter import *
import tkinter.messagebox
from ProjectHeader import *

class Gui(object):
    def __init__(self, parent):

        self.gui = parent
        
        self.gui.geometry("350x200")

        self.gui.title("Length Converter")

        self.checked1 = IntVar()
        self.checked2 = IntVar()

        self.c1 = Radiobutton(self.gui, text='(b1)Centimeters', variable=self.checked1, value = 1)
        self.c2 = Radiobutton(self.gui, text='(b2)Meter', variable=self.checked1, value = 2)
        self.c3 = Radiobutton(self.gui, text='(b3)Millimeters', variable=self.checked1, value = 3)
        self.c4 = Radiobutton(self.gui, text='(b4)Kilometers', variable=self.checked1, value = 4)

        self.c5 = Radiobutton(self.gui, text='(b5)Centimeters', variable=self.checked2, value = 5)
        self.c6 = Radiobutton(self.gui, text='(b6)Meter', variable=self.checked2, value = 6)
        self.c7 = Radiobutton(self.gui, text='(b7)Millimeters', variable=self.checked2, value = 7)
        self.c8 = Radiobutton(self.gui, text='(b8)Kilometers', variable=self.checked2, value = 8)
        
        self.b1 = Button(self.gui, text="Convert", command=self.callback)
        self.b2 = Button(self.gui, text="Exit", command=self.exit)
        self.l1 = Label(self.gui, text="Value")
        self.l2 = Label(self.gui, text="Convert ->")
        self.e1 = Entry(self.gui, bd = 5)

        self.e1.insert(0, "0")

        self.c1.pack(side = BOTTOM)
        self.c2.pack(side = BOTTOM)
        self.c3.pack(side = BOTTOM)
        self.c4.pack(side = BOTTOM)
        self.c5.pack(side = BOTTOM)
        self.c6.pack(side = BOTTOM)
        self.c7.pack(side = BOTTOM)
        self.c8.pack(side = BOTTOM)

        self.l1.pack(side = TOP)
        self.l2.pack(side = TOP)
        self.e1.pack(side = TOP)
        self.b1.pack(side = TOP)
        self.b2.pack(side = TOP)

        self.c1.place(x = 3, y = 90)
        self.c2.place(x = 3, y = 110)
        self.c3.place(x = 3, y = 130)
        self.c4.place(x = 3, y = 150)
        self.c5.place(x = 235, y = 90)
        self.c6.place(x = 235, y = 110)
        self.c7.place(x = 235, y = 130)
        self.c8.place(x = 235, y = 150)

        self.l2.place(x = 140, y = 110)

        self.b1.place(x = 107, y = 50)
        self.b2.place(x = 210, y = 50)
        
    def exit(self):
        self.gui.destroy()

    def callback(self):
    
        if self.e1.get() == "0":
            messagebox.showinfo("Error", "Please enter a value")
        elif self.checked1.get() == 1: #Centimeters
            C = Centimeters(self.e1.get())
            if self.checked2.get() == 5:
                messagebox.showinfo("Value", str(self.e1.get()) + ' cm')
            if self.checked2.get() == 6:
                value = C.ToMeters()
                messagebox.showinfo("Value", str(value) + ' m')
            if self.checked2.get() == 7:
                value = C.ToMillimeters()
                messagebox.showinfo("Value", str(value) + ' mm')
            if self.checked2.get() == 8:
                value = C.ToKilometers()
                messagebox.showinfo("Value", str(value) + ' km')

        elif self.checked1.get() == 2: #Meters
            M = Meters(self.e1.get())
            if self.checked2.get()  == 5:
                value = M.ToCentimeters()
                messagebox.showinfo("Value", str(value) + ' cm')
            if self.checked2.get()  == 6:
                messagebox.showinfo("Value", str(self.e1.get()) + ' m')
            if self.checked2.get()  == 7:
                value = M.ToMillimeters()
                messagebox.showinfo("Value", str(value) + ' mm')
            if self.checked2.get() == 8:
                value = M.ToKilometers()
                messagebox.showinfo("Value", str(value) + ' km')

        elif self.checked1.get() == 3: #Millimeters
            Mi = Millimeters(self.e1.get())
            if self.checked2.get()  == 5:
                value = Mi.ToCentimeters()
                messagebox.showinfo("Value", str(value) + ' cm')
            if self.checked2.get()  == 6:
                value = Mi.ToMeters()
                messagebox.showinfo("Value", str(value) + ' m')
            if self.checked2.get()  == 7:
                messagebox.showinfo("Value", str(self.e1.get()) + ' mm')
            if self.checked2.get()  == 8:
                value = Mi.ToKilometers()
                messagebox.showinfo("Value", str(value) + ' km')

        elif self.checked1.get() == 4: #Kilometers
            K = Kilometers(self.e1.get())
            if self.checked2.get()  == 5:
                value = K.ToCentimeters()
                messagebox.showinfo("Value", str(value) + ' cm')
            if self.checked2.get()  == 6:
                value = K.ToMeters()
                messagebox.showinfo("Value", str(value) + ' m')
            if self.checked2.get()  == 7:
                value = K.ToMillimeters()
                messagebox.showinfo("Value", str(value) + ' mm')
            if self.checked2.get()  == 8:
                messagebox.showinfo("Value", str(self.e1.get()) + ' km')
        else:
            messagebox.showinfo("Error", "Please Select the options")

root = Tk()

my_window = Gui(root)

root.mainloop()



