.syntax unified
.align 2
.global  myadd
.type    myadd,	%function

		
myadd:                     // Function "myadd" entry point.

        push {r4-r9}

	LDM r0!,{r3-r6}  //a 
        LDM r1!,{r7-r10} //b
	ADD r3,r3,r7
	ADD r4,r4,r8
	ADD r5,r5,r9
	ADD r6,r6,r10
	STM r2!,{r3-r6}

	LDM r0!,{r3-r4}
        LDM r1!,{r7-r8}
	ADD r3,r3,r7
	ADD r4,r4,r8
	STM r2!,{r3-r4}
	
	pop {r4-r9}
	bx      lr           // Return by branching to the address in the link register.



.global   mymult
.type    mymult, %function
			
mymult:                     // Function "mymult" entry point.

        push {r4-r9}
	MOV R8,R2 //backing up result index array
	MOV R7,R1 //backing up b index array
	
	//Column #0, which means a[0] x b[0-5] +r[0]
	
	
        LDM r0,{r3}    	//a[0]
        LDM r1!,{r4}   	//b[0]
	UMULL R5, R6, R3, R4 //multiplying low and high terms because result is 64 bit number
	STM R2!, {R5-R6} //store as 64 bit array

        LDM r0,{r3}    	//a[0]
        LDM r1!,{r4}   	//b[1]
	UMULL R5, R6, R3, R4
	STM R2!, {R5-R6}

        LDM r0,{r3}	//a[0]
        LDM r1!,{r4}	//b[2]
	UMULL R5, R6, R3, R4
	STM R2!, {R5-R6}

        LDM r0,{r3}	//a[0]
        LDM r1!,{r4}	//b[3]
	UMULL R5, R6, R3, R4
	STM R2!, {R5-R6}

        LDM r0,{r3}	//a[0]
        LDM r1!,{r4}	//b[4]
	UMULL R5, R6, R3, R4
	STM R2!, {R5-R6}

        LDM r0!,{r3}	//a[0]
        LDM r1!,{r4}	//b[5]	
	UMULL R5, R6, R3, R4
	STM R2!, {R5-R6}



	//Column #1	which means a[1] x b[0-5] + r[1]

	MOV R1,R7   //R1 reset to original	
	ADD R2,R8,#8 //bringing R2 index back to R2[1]

	//1
	LDM r0,{r3} 	//a[1]
	LDM r1!,{r4}	//b[0]
	UMULL R5, R6, R3, R4
	LDM R2,{R3-R4}
	ADDS R5,R5,R3
        ADCS R6,R6,R4
	STM R2!, {R5-R6}
	
	//2
	LDM r0,{r3} 	//a[1]
	LDM r1!,{r4}	//b[1]
	UMULL R5, R6, R3, R4
	LDM R2,{R3-R4}
	ADDS R5,R5,R3
        ADCS R6,R6,R4
	STM R2!, {R5-R6}

	//3
	LDM r0,{r3}	//a[1]
	LDM r1!,{r4}	//b[2]
	UMULL R5, R6, R3, R4
	LDM R2,{R3-R4}
	ADDS R5,R5,R3
        ADCS R6,R6,R4
	STM R2!, {R5-R6}
	
	//4
	LDM r0,{r3}	//a[1]
	LDM r1!,{r4}	//b[3]
	UMULL R5, R6, R3, R4
	LDM R2,{R3-R4}
	ADDS R5,R5,R3
        ADCS R6,R6,R4
	STM R2!, {R5-R6}

	//5
	LDM r0,{r3}	//a[1]
	LDM r1!,{r4}	//b[4]
	UMULL R5, R6, R3, R4
	LDM R2,{R3-R4}
	ADDS R5,R5,R3
        ADCS R6,R6,R4
	STM R2!, {R5-R6}
	
	//6
	LDM r0!,{r3}	//a[1]
	LDM r1!,{r4}	//b[5]
	UMULL R5, R6, R3, R4
	LDM R2,{R3-R4}
	ADDS R5,R5,R3
        ADCS R6,R6,R4
	STM R2!, {R5-R6}


	//Column #2	which means a[2] x b[0-5] + r[2]

	MOV R1,R7   //R1 reset to original	
	ADD R2,R8,#16 //bringing R2 index back to R2[2]

	//1
	LDM r0,{r3} 	//a[2]
	LDM r1!,{r4}	//b[0]
	UMULL R5, R6, R3, R4
	LDM R2,{R3-R4}
	ADDS R5,R5,R3
        ADCS R6,R6,R4
	STM R2!, {R5-R6}
	
	//2
	LDM r0,{r3} 	//a[2]
	LDM r1!,{r4}	//b[1]
	UMULL R5, R6, R3, R4
	LDM R2,{R3-R4}
	ADDS R5,R5,R3
        ADCS R6,R6,R4
	STM R2!, {R5-R6}

	//3
	LDM r0,{r3}	//a[2]
	LDM r1!,{r4}	//b[2]
	UMULL R5, R6, R3, R4
	LDM R2,{R3-R4}
	ADDS R5,R5,R3
        ADCS R6,R6,R4
	STM R2!, {R5-R6}
	
	//4
	LDM r0,{r3}	//a[2]
	LDM r1!,{r4}	//b[3]
	UMULL R5, R6, R3, R4
	LDM R2,{R3-R4}
	ADDS R5,R5,R3
        ADCS R6,R6,R4
	STM R2!, {R5-R6}

	//5
	LDM r0,{r3}	//a[2]
	LDM r1!,{r4}	//b[4]
	UMULL R5, R6, R3, R4
	LDM R2,{R3-R4}
	ADDS R5,R5,R3
        ADCS R6,R6,R4
	STM R2!, {R5-R6}
	
	//6
	LDM r0!,{r3}	//a[2]
	LDM r1!,{r4}	//b[5]
	UMULL R5, R6, R3, R4
	LDM R2,{R3-R4}
	ADDS R5,R5,R3
        ADCS R6,R6,R4
	STM R2!, {R5-R6}

	//Column #3	which means a[3] x b[0-5] + r[3]

	MOV R1,R7   //R1 reset to original	
	ADD R2,R8,#24 //bringing R2 index back to R2[3]

	//1
	LDM r0,{r3} 	//a[3]
	LDM r1!,{r4}	//b[0]
	UMULL R5, R6, R3, R4
	LDM R2,{R3-R4}
	ADDS R5,R5,R3
        ADCS R6,R6,R4
	STM R2!, {R5-R6}
	
	//2
	LDM r0,{r3} 	//a[3]
	LDM r1!,{r4}	//b[1]
	UMULL R5, R6, R3, R4
	LDM R2,{R3-R4}
	ADDS R5,R5,R3
        ADCS R6,R6,R4
	STM R2!, {R5-R6}

	//3
	LDM r0,{r3}	//a[3]
	LDM r1!,{r4}	//b[2]
	UMULL R5, R6, R3, R4
	LDM R2,{R3-R4}
	ADDS R5,R5,R3
        ADCS R6,R6,R4
	STM R2!, {R5-R6}
	
	//4
	LDM r0,{r3}	//a[3]
	LDM r1!,{r4}	//b[3]
	UMULL R5, R6, R3, R4
	LDM R2,{R3-R4}
	ADDS R5,R5,R3
        ADCS R6,R6,R4
	STM R2!, {R5-R6}

	//5
	LDM r0,{r3}	//a[3]
	LDM r1!,{r4}	//b[4]
	UMULL R5, R6, R3, R4
	LDM R2,{R3-R4}
	ADDS R5,R5,R3
        ADCS R6,R6,R4
	STM R2!, {R5-R6}
	
	//6
	LDM r0!,{r3}	//a[3]
	LDM r1!,{r4}	//b[5]
	UMULL R5, R6, R3, R4
	LDM R2,{R3-R4}
	ADDS R5,R5,R3
        ADCS R6,R6,R4
	STM R2!, {R5-R6}


	//Column #4	which means a[4] x b[0-5] + r[4]

	MOV R1,R7   //R1 reset to original	
	ADD R2,R8,#32 //bringing R2 index back to R2[4]

	//1
	LDM r0,{r3} 	//a[4]
	LDM r1!,{r4}	//b[0]
	UMULL R5, R6, R3, R4
	LDM R2,{R3-R4}
	ADDS R5,R5,R3
        ADCS R6,R6,R4
	STM R2!, {R5-R6}
	
	//2
	LDM r0,{r3} 	//a[4]
	LDM r1!,{r4}	//b[1]
	UMULL R5, R6, R3, R4
	LDM R2,{R3-R4}
	ADDS R5,R5,R3
        ADCS R6,R6,R4
	STM R2!, {R5-R6}

	//3
	LDM r0,{r3}	//a[4]
	LDM r1!,{r4}	//b[2]
	UMULL R5, R6, R3, R4
	LDM R2,{R3-R4}
	ADDS R5,R5,R3
        ADCS R6,R6,R4
	STM R2!, {R5-R6}
	
	//4
	LDM r0,{r3}	//a[4]
	LDM r1!,{r4}	//b[3]
	UMULL R5, R6, R3, R4
	LDM R2,{R3-R4}
	ADDS R5,R5,R3
        ADCS R6,R6,R4
	STM R2!, {R5-R6}

	//5
	LDM r0,{r3}	//a[4]
	LDM r1!,{r4}	//b[4]
	UMULL R5, R6, R3, R4
	LDM R2,{R3-R4}
	ADDS R5,R5,R3
        ADCS R6,R6,R4
	STM R2!, {R5-R6}
	
	//6
	LDM r0!,{r3}	//a[4]
	LDM r1!,{r4}	//b[5]
	UMULL R5, R6, R3, R4
	LDM R2,{R3-R4}
	ADDS R5,R5,R3
        ADCS R6,R6,R4
	STM R2!, {R5-R6}


	//Column #5	which means a[5] x b[0-5] + r[5]

	MOV R1,R7   //R1 reset to original	
	ADD R2,R8,#40 //bringing R2 index back to R2[5]

	//1
	LDM r0,{r3} 	//a[4]
	LDM r1!,{r4}	//b[0]
	UMULL R5, R6, R3, R4
	LDM R2,{R3-R4}
	ADDS R5,R5,R3
        ADCS R6,R6,R4
	STM R2!, {R5-R6}
	
	//2
	LDM r0,{r3} 	//a[4]
	LDM r1!,{r4}	//b[1]
	UMULL R5, R6, R3, R4
	LDM R2,{R3-R4}
	ADDS R5,R5,R3
        ADCS R6,R6,R4
	STM R2!, {R5-R6}

	//3
	LDM r0,{r3}	//a[4]
	LDM r1!,{r4}	//b[2]
	UMULL R5, R6, R3, R4
	LDM R2,{R3-R4}
	ADDS R5,R5,R3
        ADCS R6,R6,R4
	STM R2!, {R5-R6}
	
	//4
	LDM r0,{r3}	//a[4]
	LDM r1!,{r4}	//b[3]
	UMULL R5, R6, R3, R4
	LDM R2,{R3-R4}
	ADDS R5,R5,R3
        ADCS R6,R6,R4
	STM R2!, {R5-R6}

	//5
	LDM r0,{r3}	//a[4]
	LDM r1!,{r4}	//b[4]
	UMULL R5, R6, R3, R4
	LDM R2,{R3-R4}
	ADDS R5,R5,R3
        ADCS R6,R6,R4
	STM R2!, {R5-R6}
	
	//6
	LDM r0!,{r3}	//a[4]
	LDM r1!,{r4}	//b[5]
	UMULL R5, R6, R3, R4
	LDM R2,{R3-R4}
	ADDS R5,R5,R3
        ADCS R6,R6,R4
	STM R2!, {R5-R6}

	pop {r4-r9}
	bx      lr           // Return by branching to the address in the link register.

//end
