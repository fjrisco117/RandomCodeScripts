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
            print("Something will be here")
            self.menu()
        elif choice == "C" or choice =="c":
            print("Something will be here")
            self.menu()
        elif choice=="D" or choice=="d":
            print()
            self.grandReport()
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

    def main(self):
        self.menu()


num1=ParkingTicket()
num1.main()