import sys #this allows you to use the sys.exit command to quit/logout of the application
import os # on windows will allow to clear screen

class ParkingTicket:
  
    ticketNumberList = [10256,19875,17256]
    currency = [125.00, 500.00, 301.75]
    tagNum = ["70DCH80", "33HIK51", "55DDE77"]
    payStatus = ["PAID", "UNPAID","UNPAID"]
    

    def menu(self):
        print("**********PARKING TICKET SYSTEM************")
        print()

        choice = input("""
                          A: Create a New Parking Ticket
                          B: Pay a Parking Ticket
                          C: Report by Plate Number
                          D: Grand Report
                          Q: Quit/Log Out

                          Please enter your choice: """)

        if choice == "A" or choice =="a":
            self.createTicket()
            input("Press any key to go back to menu...")
            os.system('clear')
            self.menu()
        elif choice == "B" or choice =="b":
            print("Pay Ticket")
            print()
            self.payTicket()
            input("Press any key to go back to menu...")
            os.system('clear')
            self.menu()
        elif choice == "C" or choice =="c":
            print()
            self.reportPlateNum()
            input("Press any key to go back to menu...")
            os.system('clear')
            self.menu()
        elif choice=="D" or choice=="d":
            print()
            self.grandReport()
            self.totalPaidUnPaid()
            input("Press any key to go back to menu...")
            os.system('clear') #will clear screen
            self.menu()
        elif choice=="Q" or choice=="q":
            print("Good Bye!")
            sys.exit
        else:
            print("You must only select either A,B,C, or D.")
            print("Please try again")
            self.menu()


    def createTicket(self):

        ticketNum = 0
        while ticketNum<1 or ticketNum>20000:
            ticketNum = int(input("Enter Ticket Number, must be 1 to 20000: "))        

        tickAm = int(input("Enter ticket Amount: "))
        PlateNum = input("Enter Plate Number: ")

        self.ticketNumberList.append(ticketNum)
        self.currency.append(tickAm)
        self.tagNum.append(PlateNum)
        self.payStatus.append("UNPAID")
          
        print() #empty line
        print("new ticket entered..")
        print()

    def payTicket(self):

        tixIndex = 0 #index where searched ticket is located
        found = 0 # ticket found flag, intially set to 0 or not found
        tickAm = int(input("Enter ticket number you want to pay: "))

        for x in self.ticketNumberList:
          if x == tickAm:
            #print("Ticket index: "+ str(tixIndex))
            found = 1 # set to 1 when tix number is found
            break
          #else:
            #print("ticket not found..")
          tixIndex += 1 #increments index to search through array
        
        if found == 1:
          print()
          print("Ticket Found")
          self.payStatus[tixIndex]="PAID"
          print("Ticket Number: "+ str(self.ticketNumberList[tixIndex])+
            "| Amount Due: "+ str(self.currency[tixIndex])+
            "| Tag Number: "+ self.tagNum[tixIndex]+
            "| Status: "+ self.payStatus[tixIndex]+
            "\n") 

        else:
          print("Ticket not found") 

    def reportPlateNum(self):

        tixIndex = 0 #index where searched ticket is located
        
        print("Plate Number Report")
        print()
        
        plateNum = input("Enter plate number using Upper Case Letters: ")

        for x in self.tagNum:
          if x == plateNum:
            print("Ticket Number: "+ str(self.ticketNumberList[tixIndex])+
            "| Amount Due: "+ str(self.currency[tixIndex])+
            "| Tag Number: "+ self.tagNum[tixIndex]+
            "| Status: "+ self.payStatus[tixIndex]+
            "\n") 

          tixIndex += 1 #increments index to search through array

        


            
        

    def grandReport(self):
        size = len(self.ticketNumberList)
        #all arrays are going to be the same size because
        #it contains the same amount of elements

        #we use str() to convert numbers to strings and 
        #concatenate it with strings
        for x in range(size): 
            print("Ticket Number: "+ str(self.ticketNumberList[x])+
            "| Amount Due: "+ str(self.currency[x])+
            "| Tag Number: "+ self.tagNum[x]+
            "| Status: "+ self.payStatus[x]+
            "\n") 
    
    def totalPaidUnPaid(self):
        paid=0  #totalticketspaid
        unpaid=0 #totalticketsunpaid
        tixIndex = 0 #index where searched ticket is located
        for x in self.payStatus:
            if self.payStatus[tixIndex]=='UNPAID':
              unpaid+=1
            else:
              paid+=1
            tixIndex+=1

        print()
        print("Total Unpaid Tickets: "+str(unpaid))
        print("Total Paid Tickets: "+str(paid))
        print()
  



    def main(self):
        self.menu()


num1=ParkingTicket()
num1.main()
