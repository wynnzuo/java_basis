# 概述
<pre>
本项目主要实现关键词提取，文本摘要以及情感分析功能。
</pre>

# 环境
- python2.7
- java

# 依赖包
- jieba
- gensim
- scikit-learn
- flask

# 情感分析服务
- 启动服务
    ```
    # PORT: 端口号
    java -jar ./news_sentiment/jars/NLP-Sentiment-Analysis.jar PORT
    ```
    
- 输入
    <pre>
    # title: 标题
    # context: 正文
    
    {'title': '', 'context': ''}
    </pre>
 
- 输出
    <pre>
    # 正确调用：
    # Score: 得分
    # Polar: 情感倾向 (MIDDLE|POSITIVE|NEGATIVE)
    {'result': {'Score': '', 'Polar': ''}}
    
    # 错误调用
    # errcode: 状态码
    # errmsg: 错误信息
    {'errcode': '', 'errmsg': '', 'result': {}}
    </pre>
    
- python3使用示例
    <pre>
    import requests
    import json
    
    input = {'title': '', 'context': '今天，我很不高兴'}
    
    html = requests.post('http://host:PORT', data=json.dumps(input, ensure_ascii=False).encode("utf-8"))
    print(html.json())
    
    
    output:
    {'result': {'Score': '-0.24', 'Polar': 'NEGATIVE'}}
    </pre>

# 文本摘要及关键词提取服务 
- 启动服务
    <pre>
    # --host: ip地址
    # --port: 端口号
    
    python summary_keywords_server.py --host=host --port=port
    </pre>
    
- 输入
    <pre>
    # text: 文本内容
    
    {'text': ''}
    </pre>
    
- 文本摘要输出
    <pre>
    # summary: 摘要
    # message: 调用返回信息
    # status: 状态码，0：调用成功，1：调用失败
    
    {'summary': '', 'message': '', 'status': ''}
    </pre>
    
- 关键词输出
    <pre>
    # keywords: [关键词]
    # message: 调用返回信息
    # status: 状态码，0：调用成功，1：调用失败
    
    {'keywords': [], 'status': '', 'message': ''}
    </pre>  
    
    
- python3使用示例
    <pre>
    input = {
            'text': """传销分为“北派”传销和“南派”传销。“入侵”观山湖的传销,都属于“南派”传销。组织者冠以“纯资本运作”和“1040工程”等的名义,声称是国家秘密项目,刚加入的成员需要缴纳69800元“会费”,之后就要不断地发展“业务员”,根据发展的人数按照“五级三晋制”的规定晋级获利,两年后就赚到1040万元。
    
            观山湖区初次与传销“交手”,采取的办法是,由社区人员带路,公安、工商执法人员直捣传销窝点,发现一处,清理一处。
    
            但传销人员打起了“游击”,执法人员端掉了一个窝点,不久,传销人员又折回,重新租房继续搞传销。到了后来,遣返走了广西体系,湖南体系又来了,湖南体系被遣返了,江西体系又来了,可谓是防不胜防,屡禁不止。
    
            而且,被打击后,狡猾的组织者对被骗入的传销人员声称,这是国家在进行“宏观调控”,目的是清理走一批意志不坚定的人,同时,因为参与的人太多,也要清理走一批人,不然,大家都来参与这一秘密项目,将来谁来种粮食?谁来开餐馆?谁来开出租车?
    
            王骞，观山湖区公安分局经侦大队民警，2012年，他参与了“5·07”特大传销案的侦破工作。这起案件,在经营了一年多后,最终抓获了李尧江等32名传销骨干。此案一次成功依法打击32名涉嫌传销的犯罪嫌疑人,当时在全国尚属首例,为此,公安部、省公安厅还专门发来贺电。"""
    }
    
    html = requests.post('http://host:port/summary', data=json.dumps(input, ensure_ascii=False).encode("utf-8"))
    print(html.json())
    
    
    output:
    {'summary': '传销分为“北派”传销和“南派”传销。“入侵”观山湖的传销,都属于“南派”传销。组织者冠以“纯资本运作”和“1040工程”等的名义,声称是国家秘密项目,刚加入的成员需要缴纳69800元“会费”,之后就要不断地发展“业务员”,根据发展的人数按照“五级三晋制”的规定晋级获利,两年后就赚到1040万元。'}
    
    
    html = requests.post('http://host:port/keywords', data=json.dumps(input, ensure_ascii=False).encode("utf-8"))
    print(html.json())
    
    output:
    {'keywords': ['清理', '秘密', '声称', '组织者', '南派', '窝点', '湖南', '传销案', '公安分局经侦大队民警', '名义', '公安部', '出租车', '北派', '骨干', '交手', '人数', '会费', '三晋制', '不久', '专门'], 'status': '0', 'message': 'success'}
    </pre>

