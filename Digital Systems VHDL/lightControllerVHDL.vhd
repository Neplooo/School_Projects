library ieee;
use ieee.std_logic_1164.all;

entity lightControllerVHDL is
	port(
	In01 : in BIT; -- Switch 1
	In02 : in BIT; -- Switch 2
	Output : out BIT); -- Output LED
end lightControllerVHDL;

architecture Behavioral of lightControllerVHDL is

begin
	select_proc : process(In01, In02) --Register the procesess with the board.
	begin
		if In01 /= In02 then -- If the two switches are different, that means one switch is on.
			
			Output <= '1'; -- Turn on the light.
			
		else -- If the two switches have the same value, that means that the NOR gate should not send anything.
		
			Output <= '0'; -- Turn off the light.
		
		end if;
	end Process;
end Behavioral;