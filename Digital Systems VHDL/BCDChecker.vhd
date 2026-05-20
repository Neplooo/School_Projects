library ieee;
use ieee.std_logic_1164.all;
 
entity BCDChecker is
  port (
    I0 : in std_logic;
    I1 : in std_logic;
    I2 : in std_logic;
    I3 : out std_logic;
    O  : out std_logic);
end BCDChecker;

 
architecture Behavioral of BCDChecker is
  
begin
    process(I0, I1, I2, I3, O)
    begin
        if I3 = "1" and I0 = "1" then
            O <= "1";
        else
            O <= "0";
        end if; 
    end process;
end Behavioral;