library ieee;
use ieee.std_logic_1164.all;

entity ProgLogicUnit is
	port(
	en : in BIT; -- Enable Bit
	s0 : in BIT; -- Config Bit 1
	s1 : in BIT; -- Config Bit 2
	
	a0 : in BIT; -- 3 Bit Array A
	a1 : in BIT;
	a2 : in BIT;

	b0 : in BIT; -- 3 Bit Array B
	b1 : in BIT;
	b2 : in BIT;
	
	o1 : out BIT; -- Output LED
	o2 : out BIT;
	o3 : out BIT); 
end ProgLogicUnit;

architecture Behavioral of ProgLogicUnit is

begin
	select_proc : process(en, s0, s1, a0, a1, a2, b0, b1, b2) --Register the procesess with the board.
	begin
	
		if en = '0'	then
			o1 <= '0';
			o2 <= '0';
			o3 <= '0';
		else
		
			if s0 = '0' and s1 = '0' then
				o1 <= a0 or b0;
				o2 <= a1 or b1;
				o3 <= a2 or b2;
				
			--else if is just one world "elsif"
			elsif s0 = '1' and s1 = '0' then
				o1 <= a0 and b0;
				o2 <= a1 and b1;
				o3 <= a2 and b2;
			elsif s0 = '0' and s1 = '1' then
				o1 <= a0 xor b0;
				o2 <= a1 xor b1;
				o3 <= a2 xor b2;
			else
				o1 <= not a0;
				o2 <= not a1;
				o3 <= not a2;
			end if;
		
		end if;
		
	end Process;
end Behavioral;