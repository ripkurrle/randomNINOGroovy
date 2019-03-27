/* 
 * Title - Simple Groovy script to generate a valid NINO
 * Prerequisite - TestCase Property named RandomNINO
*/

def randomChars = { String alphabet, int i ->
    new Random().with {
        (1..i).collect { alphabet[ nextInt( alphabet.length() ) ] }.join()
    }
}

//exclusions
String nino = randomChars( ('A'..'Z').join(), 2 )

while(true)
{
  if(Arrays.asList("D", "F", "I", "Q", "U", "V").contains(nino[0]))
  {
    println 'DEBUG: ' + nino
    nino = randomChars( ('A'..'Z').join(), 2 )
    continue
  }

  if(Arrays.asList("BG", "GB", "NK", "KN", "TN", "NT", "ZZ").contains(nino[0]))
  {
    println 'DEBUG: ' + nino
    nino = randomChars( ('A'..'Z').join(), 2 )
    continue
  }
  break
}

nino = nino + randomChars( ('0'..'9').join(), 6 ) + randomChars( ('A'..'D').join(), 1 )
testRunner.getTestCase().setPropertyValue("RandomNINO", nino);
