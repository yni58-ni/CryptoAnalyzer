# CryptoAnalyzer
<img width="820" alt="Screen Shot 2022-01-05 at 5 26 42 PM" src="https://user-images.githubusercontent.com/61612345/148298401-0e7f8b15-920f-4834-b838-fa95a184032d.png">

# Purpose
For this project, we will specify, design and implement a system that can: retrieve data related to cryptocurrency prices from the “CoinGecko” cryptocurrency repository, process said data (if required) using a wide array of different types of analyses, and finally rendering the data retrieved from CoinGecko or the processed data using a variety of techniques (such as bar graphs, scatter charts, tables and line-graphs). The system will also have a User Interface (UI) that will allow the user to make selections of the parameters they wish to use. The UI will also be responsible for rendering the data (either the data retrieved from CoinGecko, or the analyzed data).
# Overview
This system will be used for helping the user with quick access to vital information of different cryptocurrencies. It will also allow the user to create quick, easy to understand analysis rendered by the system seamlessly into different styles of data representation as mentioned above. Overall, this will be useful for all cryptocurrency enthusiasts, as it will act as an all-in-one tool for information gathering, analysis and presentation of data.
There will then be 8 different types of analysis the user can perform on any of the above cryptocurrencies. For the first four types, the user will select a start date and a frequency interval as parameters for the analysis, then they will choose what they wish to have analyzed. The choices for said analysis are: unit price, market capitalization, transaction volume, and coins in circulation. The other four types of analysis require the user to select one interval to another. These four types of analysis are: percent change of unit price, percent change of market cap value, percent change of transaction volume and percent change of coins in circulation.
In order to implement this system, we will retrieve the data for one or more of the cryptocurrencies listed above, this data will be related to: the current price, market capitalization and 24h volume of transactions. This data will be retrieved using the “CoinGecko” published REST API. Once the data is collected, it may be processed depending on which type of analysis the user wants to perform.
# Reference
Additional resources can be found here, containing additional information as well as useful figures of the program to help further visualize and understand the system.
Eclipse: https://www.eclipse.org/downloads/index.php
CoinGecko’s REST API: https://www.coingecko.com/api/documentations/v3 CoinGecko: https://www.coingecko.com/en
GANTT: https://en.wikipedia.org/wiki/Gantt_chart
