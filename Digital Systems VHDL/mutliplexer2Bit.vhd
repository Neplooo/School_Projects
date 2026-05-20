library ieee;
use ieee.std_logic_1164.all;
 
entity twoBitMultiplexer is
  port (
    I0 : in std_logic;
    I1 : in std_logic;
    S  : in std_logic;
    O  : out std_logic);
end twoBitMultiplexer;

 
architecture Behavioral of twoBitMultiplexer is
  
begin
    process(I0, I1, S)
    begin
        if S = "0" then
            O <= I0;
        else
            O <= I1;
        end if; 
    end process;
end Behavioral;