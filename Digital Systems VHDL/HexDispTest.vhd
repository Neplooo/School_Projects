library ieee;
use ieee.std_logic_1164.all;

entity HexDispTest is
    Port ( 
        inputHex : in  STD_LOGIC_VECTOR (3 downto 0); -- 4-bit Hex input
        segOut   : out STD_LOGIC_VECTOR (6 downto 0)  -- 7-bit output to HEX pins
    );
end HexDispTest;


architecture Behavioral of HexDispTest is
begin
	select_proc : process(inputHex)
	begin
		-- Standard 7-segment mapping (Active-Low)
      -- segOut bits correspond to: [6:g, 5:f, 4:e, 3:d, 2:c, 1:b, 0:a]
	  case inputHex is
			when "0000" => segOut <= "1000000"; -- 0
			when "0001" => segOut <= "1111001"; -- 1
			when "0010" => segOut <= "0100100"; -- 2
			when "0011" => segOut <= "0110000"; -- 3
			when "0100" => segOut <= "0011001"; -- 4
			when "0101" => segOut <= "0010010"; -- 5
			when "0110" => segOut <= "0000010"; -- 6
			when "0111" => segOut <= "1111000"; -- 7
			when "1000" => segOut <= "0000000"; -- 8
			when "1001" => segOut <= "0010000"; -- 9
			when "1010" => segOut <= "0001000"; -- A
			when "1011" => segOut <= "0000011"; -- b
			when "1100" => segOut <= "1000110"; -- C
			when "1101" => segOut <= "0100001"; -- d
			when "1110" => segOut <= "0000110"; -- E
			when "1111" => segOut <= "0001110"; -- F
			when others => segOut <= "1111111"; -- All OFF
	  end case;
	end process;
end Behavioral;