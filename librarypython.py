class Library:
    books=[]
    issued=[]
    count=0
    choice=int()

    def addbook(self,bookname):
          self.books.append(bookname)
          self.issued.append(False)
          self.count+=1
          print("\n Book added successfully")    
            
    def displaybook(self):
        if(self.count==0):
            print("\n no books available")
        else:
            print("\n Available books")
            for i in range(0,self.count): #for i in range(0,len(self.books):
               print((i + 1) , "." , self.books[i],("(Issued)" if self.issued[i] else " (Available)"))
    

    def issuebook(self,index):
         if(index<0 or index>=self.count):
            print("\n invalid book number")
         elif(self.issued[index]):
             print("\n Book already issued")
         else:
             self.issued[index]=True
             print("\n Book issued successfully")

      
    def returnbook(self,index):
          if(index<0 or index>=self.count):
            print("\n invalid book number")
          elif(not self.issued[index]):
             print("\n Book was not issued")
          else:
             self.issued[index]=False
             print("\n Book returned successfully")

lib=Library() 
while True:
        print("\n ======library menu======")
        print("\n 1.Add Book")
        print("\n 2.Display Books")
        print("\n 3.Issue Book")
        print("\n 4.Return Book")
        print("\n 5.Exit")
        choice=int(input("Enter your choice"))

        
        match choice:
            case 1:
                name=input("\n Enter bookname:")
                lib.addbook(name)
            case 2:
                lib.displaybook()
            case 3:
                iss=int(input("\n Enter booknumber to issue:"))-1
                lib.issuebook(iss) 
            case 4:
               index = int(input("Enter book number to return: ")) - 1
               lib.returnbook(index)
            case 5:
                print("exited")
                break
            case _:
                print("\n something wrong")
                
        

