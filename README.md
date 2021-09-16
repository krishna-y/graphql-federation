# graphql-federation


RUN : MDDS, SDDS, CDDS, ADDS

RUN : applo-gateway  ->  node index.js

Play on : http://localhost:4000/


Queries

**UNION**
```
query{
  mastHeadList(pid: "2"){
    __typename
    ... on ContentItem{
      cid,
      description
    }
   ... on AdvtItem{
    aid,
    url
  } 
    ... on SportsItem{
      cid,
      score,
      title,
      description
    }
    
  }
}
```

**Composition**
```
query{
  mastHead(pid: "2"){
    contentItems{
      cid,
      description
    },
    advtItems{
    	aid,
    	url
    } ,
    sportsItems{
      cid,
      score,
      title,
      description
    }
    
  }
}
```
