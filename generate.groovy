// Simple Groovy script to generate a valid NINO

def startChars = { String alphabet, int i ->
  new Random().with {
    (1..i).collect { alphabet[ nextInt( alphabet.length() ) ] }.join()
  }
}
def midNums = { String alphabet, int i ->
  new Random().with {
    (1..i).collect { alphabet[ nextInt( alphabet.length() ) ] }.join()
  }
}
def endChar = { String alphabet, int i ->
  new Random().with {
    (1..i).collect { alphabet[ nextInt( alphabet.length() ) ] }.join()
  }
}
nino = startChars( ('A'..'Z').join(), 2 ) + midNums( ('0'..'9').join(), 6 ) + endChar( ('A'..'Z').join(), 1 )
testRunner.getTestCase().setPropertyValue("nino", randomValue);
