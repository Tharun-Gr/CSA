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
> ### ***Perform step by step instructions:***
>> #### 1. Upload the IPL.txt file  
>> - Click the init button and upload the IPL.txt .  
>> - IPL.txt present inside src/docs  
>
>> #### 2. Check the initial load operation:
>> - ***After step 1:*** Once upload IPL.txt completed, type 0000 in input box.  
>> - Then click load button beside MAR.
>> - You can now see the value 0000 loaded to MAR.
>> - Now, click main Load button which would fetch the content  
>> from the memory location 0000.
>> - It displays value 0001 in MBR.
>
>> #### 3. Check the initial store operation:
>> - ***After step 2:*** After initial load, type 0006 in input box.  
>> - Click the load button beside MAR to load.
>> - Then type 0008 in input and click load beside MBR.
>> - Now click the store button. The value gets stored in the main memory.
>
>> #### 4. LDR: ***Load Register From Memory***
>> - ***After step 3:*** Type 000B in input. Use SS button to execute.
>> - You'll get 0002 in GPR1. Because 00001 location has 0002 content.
>
>> #### 5. STR: ***Store Register To Memory***
>> - ***After step 4:*** Now the PC get incremented.
>> - Use SS to execute.
>> - 0002 value from GPR0 sets to 0002 location. 
>> - So, the value of 0002 will be 0002.
>
>> #### 6. LDA: ***Load Register with Address***
>> - ***After step 5:*** Now the PC get incremented.
>> - Use SS to execute.
>> - 0004 location in instruction loads to GPR1.
>
>> #### 7. LDX: ***Load Index Register from Memory***
>> - ***After step 6:*** Now the PC get incremented.
>> - Use SS to execute.
>> - 0004 location has 0008 value. So, the value gets loaded to IXR1.
>
>> #### 8. STX: ***Store Index Register to Memory***
>> - ***After step 7:*** Now the PC get incremented.
>> - Use SS to execute.
>> - IXR1 has 0008 value and the address value is 0000. Adds to 0008.
>> - So, the value 0008 gets loaded to memory location 0008.