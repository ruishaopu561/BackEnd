# Homework 2
> * How to use F12
> > * Analyze the home page loading of SJTU
> > > * Compare with other website home pages 
> > > * Carry out your optimization solution
> * Write down your investigation and solution in Markdown.
> > * submit to your repo.
## Network
### SJTU
![First Loading](https://github.com/ruishaopu561/BackEnd/tree/master/hw2/1.jpg)
### FU
![First Loading](https://github.com/ruishaopu561/BackEnd/tree/master/hw2/2.jpg) 
### THU
![First Loading](https://github.com/ruishaopu561/BackEnd/tree/master/hw2/3.jpg) 
### PKU
![First Loading](https://github.com/ruishaopu561/BackEnd/tree/master/hw2/4.jpg)

## Performance
### SJTU
![First Loading](https://github.com/ruishaopu561/BackEnd/tree/master/hw2/1.jpg)
### FU
![First Loading](https://github.com/ruishaopu561/BackEnd/tree/master/hw2/2.jpg) 
### THU
![First Loading](https://github.com/ruishaopu561/BackEnd/tree/master/hw2/3.jpg) 
### PKU
![First Loading](https://github.com/ruishaopu561/BackEnd/tree/master/hw2/8.png)

## Advantage/Disadvantages
### advantage
> * SJTU uses https protocol, while other three universities uses http protocol.

### disadvantage
> * SJTU is much slower than other three universities.

## Analysis
SJTU:  
> * loads more images
> * Non-parallel processing
> * use less disk cache and more http requests
other:
> * less images
> * parallel processing
> * use more disk cache and less http requests

## Advice
> * less images or compress images
> * so more parallel processing
> * use more disk cache and less http requests

## Reference
- [SJTU](http://electsys.sjtu.edu.cn/edu/)
- [FU](http://www.fudan.edu.cn/mindex.html)
- [THU](http://www.tsinghua.edu.cn/publish/thu2018en/index.html)
- [PKU](http://english.pku.edu.cn/)