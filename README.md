# PPKWU_3
API used to count character types in given text. It delegates the works of processing text to another server.
It returns response in diffrent way: json, xml, csv and txt. Depneding on syntax.
To use API, u need to sent GET method and pass parameter text.

## Json syntax
```
/json/?text=
```
## Xml syntax
```
/xml/?text=
```
## Csv syntax
```
/csv/?text=
```
## Txt syntax
```
/txt/?text=
```

## Example call with xml
```
http://localhost:1234/xml/?text=KaJaK 123..,,
```
## Result
Returns as xml
```
<response>
    <specialCharacterCounter>4</specialCharacterCounter>
    <digitCounter>3</digitCounter>
    <upperCaseCounter>3</upperCaseCounter>
    <textToProcess>KaJaK 123..,,</textToProcess>
    <lowerCaseCounter>2</lowerCaseCounter>
    <whiteSpaceCounter>1</whiteSpaceCounter>
</response>
```
Returns as json
```
{
    "textToProcess": "KaJaK 123..,,",
    "upperCaseCounter": 3,
    "lowerCaseCounter": 2,
    "digitCounter": 3,
    "whiteSpaceCounter": 1,
    "specialCharacterCounter": 4
}
```
Returns as csv
```
specialCharacterCounter,digitCounter,upperCaseCounter,textToProcess,lowerCaseCounter,whiteSpaceCounter
4,3,3,"KaJaK 123..,,",2,1
```
Returns as txt
```
Text: KaJaK 123..,,
upperCase: 3
lowerCase: 2
digits: 3
whiteCharacters: 1
specialCharacters: 4
```
