# J.M.T.W.C
## _Java Multithreaded Web Crawler_
[![JMTWC at work](https://iili.io/4TvVDX.md.png)](https://freeimage.host/i/4TvVDX)


J.M.T.W.C, is a free and open source web crawler powered by [JSOUP](https://jsoup.org/)
Credit mostly goes to [CodingWithTim](https://www.youtube.com/c/CodingWithTim) as this is his script only modified by me.
 
## Features

- Multi-threaded Web Crawling.
- Allowing user to choose which site(s) they wish to crawl (via CLI).
- Allowing user to choose the depth of the bot(s).
- Database storage of the links.
- Perhaps more in the future.

## Usage
- Insert the URL(S) you wish to crawl,
- Determine depth of crawl for bots,
- Press enter and let the magic happen.
- Database generated is SQLite, use [DBBrowser](https://sqlitebrowser.org/) to check contents of Database. It is free and open-source.

## Setup
You are required to Create a folder inside named 'Database',
- Create a SQLite Database inside the folder named : 'SiteIndex'
- Inside this database, create a table named Sites.
- Sites table should contain 3 rows : Web_Url,Bot_Id,Title. All of which are case sensitive.
I will fix this in next commits so the folder and DB are automatically created.

## Arguments 
- For now there are two arguments available for you to take advantage of.
- `--flush` can be used to remove everything inside the database.
- `--unsafe` can be used to remove limit for amount of links you can insert.
- `--generate` can be used to generate database if it doesn't exist yet.

## Current Known Bugs
- Crawler when facing phone numbers crash out because it is not a viable URL.

## Lisence
You can modifiy and use the project as it is GPL-3 Lisence. As free as it gets when it comes to FOSS.
