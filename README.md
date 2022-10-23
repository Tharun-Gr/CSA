# CSA Project

> ### Source code: 
> - src/main/java/com/gwu/csa

> ### To start the application:
> - Run the CsaApp.java file.  
> - It will open GUI popup of simulation.
> - If you want to know the memory and instruction, check src/docs/IPL.txt

> ### Main memory:
>  - From 0000 to 000A - allocated for memory.  
>  - From 000B to end  - allocated for instruction.

> ### Directions to perform instructions on GUI:
>> ### ***Perform step-by-step instructions for phase 1:***
>>> #### 1. Upload the IPL.txt file  
>>> - Click the init button and upload the IPL.txt .  
>>> - IPL.txt present inside src/docs  
>>
>>> #### 2. Check the initial load operation:
>>> - ***After step 1:*** Once upload IPL.txt completed, type 0000 in input box.  
>>> - Then click load button beside MAR.
>>> - You can now see the value 0000 loaded to MAR.
>>> - Now, click main Load button which would fetch the content  
>>> from the memory location 0000.
>>> - It displays value 0001 in MBR.
>>
>>> #### 3. Check the initial store operation:
>>> - ***After step 2:*** After initial load, type 0006 in input box.  
>>> - Click the load button beside MAR to load.
>>> - Then type 0008 in input and click load beside MBR.
>>> - Now click the store button. The value gets stored in the main memory.
>>
>>> #### 4. LDR: ***Load Register From Memory***
>>> - ***After step 3:*** Type 000B in input. Use SS button to execute.
>>> - You'll get 0002 in GPR1. Because 00001 location has 0002 content.
>>
>>> #### 5. STR: ***Store Register To Memory***
>>> - ***After step 4:*** Now the PC get incremented.
>>> - Use SS to execute.
>>> - 0002 value from GPR0 sets to 0002 location. 
>>> - So, the value of 0002 will be 0002.
>>
>>> #### 6. LDA: ***Load Register with Address***
>>> - ***After step 5:*** Now the PC get incremented.
>>> - Use SS to execute.
>>> - 0004 location in instruction loads to GPR1.
>>
>>> #### 7. LDX: ***Load Index Register from Memory***
>>> - ***After step 6:*** Now the PC get incremented.
>>> - Use SS to execute.
>>> - 0004 location has 0008 value. So, the value gets loaded to IXR1.
>>
>>> #### 8. STX: ***Store Index Register to Memory***
>>> - ***After step 7:*** Now the PC get incremented.
>>> - Use SS to execute.
>>> - IXR1 has 0008 value and the address value is 0000. Adds to 0008.
>>> - So, the value 0008 gets loaded to memory location 0008.
>> ### ***Perform step-by-step instructions for phase 2:***
>>
>>> #### 1. JZ - 0010: ***Jump If Zero***
>>> - Load the value on GPR1.
>>> - If the value of GPR1 value is empty or zero,
>>>   then 0001 will be the value of PC because it's the EA.
>>> - Otherwise, increment the PC by 1.
>>
>>> #### 2. JNE - 0011: ***Jump If Not Equal***
>>> - Load the value on GPR1.
>>> - If the value of GPR1 value is not equal to empty or zero,
>>>   then 0001 will be the value of PC because it's the EA.
>>> - Otherwise, increment the PC by 1.
>>
>>> #### 3. JCC: ***Jump If Condition Code***
>>> - Load the value on GPR1.
>>> - ***0012*** - If the GPR1 is equal to one,
>>>   then 0001 will be the value of PC because it's the EA.
>>> - ***0013*** - Otherwise, increment the PC by 1.
>>
>>> #### 4. JMA: ***Unconditional Jump To Address***
>>> - ***0014*** - Sets EA to PC as default.
>>
>>> #### 5. JSR: ***Jump and save return***
>>> - ***0015*** - Increment PC by 1 and stored it in GPR3.
>>> - Then, sets PC as EA.
>>
>>> #### 6. RFS: ***Return from sub routine***
>>> - ***0016*** - Load/have some value in gpr3 and load 0016 to pc.
>>> - Then, execute the SS, it will set the gpr3 value to pc.
>>
>>> #### 7. SOB: ***Subtract One and Branch***
>>> - ***0017*** - Load some value in grp3.
>>> - Enter the instruction code. Load and SS the PC.
>>> - It'll subtract by 1 of the gpr3 value.
>>> - If the subtracted value greater than 0, then set EA value to PC.
>>> - Otherwise, increment the PC by 1.
>>
>>> #### 8. JGE: ***Jump Greater Than or Equal To***
>>> - ***0018*** - Load some value in grp3.
>>> - then execute the ss.
>>> - if the gpr3 is greater than or equal to zero
>>> - then, set PC as EA
>>> - Otherwise, increment the PC by 1.
>>
>>> #### 9. AMR: ***Add memory to register***
>>> - ***0019*** - Load some value in grp0.
>>> - grp0 value will add up to EA.
>>> - The sum value will be stored in grp0.
>>
>>> #### 10. AMR: ***Add memory to register***
>>> - ***001A*** - Load some value in grp0.
>>> - grp0 value will add up to EA.
>>> - The sum value will be stored in grp0.
>>
>>> #### 11. AIR: ***Add Immediate to Register***
>>> - ***001B*** - load the value on gpr0
>>> - Add gpr0 and immediate values and store it on gpr0.
>>
>>> #### 12. SIR: ***Subtract Immediate to Register***
>>> - ***001C*** - load the value on gpr0
>>> - Subtract gpr0 and immediate values and store it on gpr0.
>>
>>> #### 13. MLT: ***Multiply register by register***
>>> - ***0037*** - Use this memory location
>>> - load the value on gpr0 and ixr2
>>> - Then, execute it'll return higher order bits on gpr0
>>> - and lower order bits on ixr2.
>>
>>> #### 14. DVD: ***Divide register by register***
>>> - ***0038*** - Use this memory location
>>> - load the value on gpr0 and ixr2
>>> - Then, execute it'll quotient on gpr0
>>> - and remainder on ixr2.
>>
>>> #### 15. TRR: ***Test the equality***
>>> - ***0039*** - Use this memory location
>>> - load the value on gpr0 and ixr2
>>
>>> #### 16. AND: ***Logical AND of register and register***
>>> - ***003A*** - Use this memory location
>>> - load the value on gpr0 and ixr2
>>> - Then, execute it'll perform logical AND on both registers
>>> - and return the value to gpr0.
>>
>>> #### 17. ORR: ***Logical Or of Register and Register***
>>> - ***003B*** - Use this memory location
>>> - load the value on gpr0 and ixr2
>>> - Then, execute it'll perform logical OR on both registers
>>> - and return the value to gpr0.
>>
>>> #### 18. NOT: ***Logical Not of Register To Register***
>>> - ***003B*** - Use this memory location
>>> - load the value on gpr0
>>> - Then, execute it'll perform logical NOT on gpr0
>>> - and return the value to gpr0.
>>
>> ### ***Perform program one:***
>>
>>> #### 1. LDR - 001D: ***040A Load Register From Memory***
>>> - Load the value of 20 to gpr0.
>>
>>> #### 2. IN - 001E: ***C400 Input from console keyboard***
>>> - Get 20 inputs from user.
>>
>>> #### 3. IN - 001E: ***C400 Input from console keyboard***
>>> - Get 20 inputs from user.
>>
>>> #### 4. SOB - 001F: ***381E Subtract one and branch***
>>> - Counter in register gets reduced one by one as user loads inputs.
>>
>>> #### 5. IN - 0020: ***C400 Input from console keyboard***
>>> - Getting the input from user to search the value which is closest.
>>
>>> #### 6. OUT - 0021: ***C800 Displaying the closest number in console output display***
>>> - Displaying the closest number from the set of 20 user inputs in console output display.
>>
>>> #### 7. From 0022 to 0035 of memory locations is allocated for user inputs
>>
>>> #### 8. 0036 memory location is allocated for user search input.
>>
>> ### ***Cache design***
>>
>>> - We've a cache design where we store last 16 lines of instruction for tracing.
