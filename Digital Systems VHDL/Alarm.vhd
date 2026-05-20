library ieee;
use ieee.std_logic_1164.all;
 
entity Alarm is
  port (
    fT : in std_logic;
    fP : in std_logic;
    fFlr : in std_logic;
    fL : in std_logic;
    O  : out std_logic);
end Alarm;

 
architecture Behavioral of Alarm is
  
begin
    process(fT, fP, fFlr, fL, O)
    begin
        if fT = "1" and fP = "1" then
            O <= "1";
        else
            O <= "0";
        end if; 
    end process;
end Behavioral;