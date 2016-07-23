package com.demo.app.androidsdkdemo;

import java.util.ArrayList;

/**
 * Created by lishaojie on 16/7/23.
 */

public class FragmentConstants {

    public static ArrayList<String> IMAGES = new ArrayList<>(3);

    static {
        IMAGES.add("https://blog.growingio.com/storage/image/3aa3161ef14d108f83cc854dc5452b1a.jpeg");
        IMAGES.add("https://blog.growingio.com/storage/image/7292df760da6d7f526452beb4de95501.png");
        IMAGES.add("https://assets.growingio.com/blog/storage/image/c5549c223dd8a8216773c8395aef174b.jpeg");
    }

    public static ArrayList<String> CONTENTS = new ArrayList<>(3);

    static {
        CONTENTS.add("SaaS平台一般采用云模式，在这个模式下可以快速扩张，服务更多客户。如果客户的数量可以规模化增长，以及能控制CAC（获客成本），引导客户长期使用平台，那采取这种模式后盈利曲线会非常陡，能够快速迭代产品、修复系统问题、增长客户数量。\n" +
                "LTV (life time value) 生命周期总价值，指的是客户在平台使用时间的长短。一般LTV越长，客户在平台贡献的收益越高。一个成功的SaaS模式，LTV要大于CAC三倍。因此客户在平台停留时间越长越好。\n" +
                "SaaS企业的漏斗模式与传统的不尽相同。漏斗上方都是让产品的受众转化为客户，从而让客户签单，让客户习惯SaaS产品的功能。但不同的是，客户初期使用SaaS软件时付出的费用很少。\n" +
                "因此SaaS软件盈利方式有两种，一是希望客户在平台上停留时间更长，二是促进客户购买、增购、复购，交叉销售更多产品给客户，引导客户消费。因此企业需要精细化衡量整个漏斗。" +
                "要让注册流非常顺滑，需要不断监测每一步的客户流失率。下面这个案例创建了注册失败的用户群体，用来研究为什么会注册失败。\n" +
                "首先创建用户分群，用户在第一个注册页面填信息的时候数量是大于0的，用户激活邮件发送这步的区间是等于0的，完善页面信息数大于0。有了分群之后，可以通过用户细节的操作来分析哪一步的注册遇到了阻力。" +
                "有了客户健康度模型之后还不够。健康度和温度之间的关系能帮我们更好销售。\n" +
                "见下图，X轴是健康度，y轴是温度，用户健康度越低，使用频率越低，用户温度越低，购买意愿越低。\n" +
                "我们可以做一个气泡图，每个气泡代表一个公司，把所有客户分布在四个象限之中：\n" +
                "右上角的客户，购买意愿高，频次高，是非常优质的客户，我们希望这些客户尝试新的产品，会推出新功能让这些客户先使用。\n" +
                "左下角是购买意愿低频次低的客户，我们就鼓励客户使用产品，引导客户用留存度高的功能，对客户进行培训。\n" +
                "左上角是购买意愿高，使用频次不高的用户，我们让客户马上埋单，把用户变成客户，先鼓励用户购买之后再慢慢像右上角推动。\n" +
                "右下角的区域，购买的意愿不高，使用频次高，这时候要了解原因，比如一些客户在平台上消耗了大量资源，但是付的钱不能覆盖成本。我们要找一些方法进行沟通，或者了解是不是多个人使用一个账号。在这上面我们会发现，按账号来卖的产品，有的用户经常多人使用一个账号。我们可以跟客户交流，给客户开更多账号等。" +
                "我们的主要目标是让客户在平台使用的时间更长。那实现客户成功的好处是什么呢？\n" +
                "实现客户成功最大的挑战是收集用户行为。有了数据还要进行数据分析，分析结果指导企业针对用户行为积极主动的运作。能指导用户行为的结果才是好的分析结果。有了用户行为数据才知道用户是怎么使用产品的，最开始购买是靠这个产品能满足需求，持续购买是靠用户体验，我们需要知道用户是怎么使用产品的，从而提高用户体验。\n" +
                "比如一款团队协作SaaS产品，里面有很多功能模块，所有功能都要对用户行为数据进行收集。大家知道传统统计方法中，收集产品功能用户数据可以通过埋点来实现。但是实际操作比较复杂，产品经理想知道产品使用情况要通知数据分析师，数据分析师要找到数据报表，找不到的话需要工程师埋点，等代码上线之后才能得到这些数据。\n" +
                "考虑到整个流程很繁琐复杂，回国创业之前，我们想了一个简单的方法帮助产品经理收集和分析数据，通过无埋点的方式收集用户数据。不管是网页端客户端还是手机APP，都能全量采集用户行为数据，做出分析报表，帮助产品经理快速发现用户行为背后的内容，对产品进行新一轮的迭代，比较之前的结果，来分析我们的结果是正确的还是错误的。\n" +
                "收集用户行为数据，判断用户行为信号，以及某个模块使用情况，所有信号都能让我们把用户分在不同象限内，采取不同行动。");
        CONTENTS.add("今天大家都听到了LinkedIn被微软262亿美元收购的消息，一个接近溢价50%的offer，把世界上第一大职业社交网络、也是世界上第二大的SaaS（软件即服务）的厂商融入到微软的迅速崛起的商业云战略中。很多朋友会问，为什么过往LinkedIn会有这么高的估值，为什么微软会溢价50%收购LinkedIn。\n" +
                "很多朋友问我，“一个社交网络值吗？”“价格是高了，还是低了？”\n" +
                "其实事务的核心往往很简单，并购、估值、溢价的本源就是“增长”。 微软收购LinkedIn在某种程度上说，是通过并购来获得进一步增长。非常重要的一点，LinkedIn 在过去6年间从一个7000万左右年营收的企业，一下子增长至30亿美元营业额的企业，五年业务增长超过40倍。这种增长速度在企业服务领域里面是惊人的。\n" +
                "6年多以前，我第一次在 LinkedIn 的公司例会上听到彼得·德鲁克的一句话，他说：如果一个事情，你不能衡量它的话，那么你就不能增长它。这句话的核心理念沉淀出了LinkedIn的企业价值观。增长带动数据分析，数据带动变现，变现进一步促进增长。而且这种文化折射出硅谷里面蔓延的精益创业的文化，即创业公司必须要做三件事——Build（建立）、Measure（衡量）、Learn（学习）。这句话在过去的6年间不断得到验证，不断通过各种各样的方式在产品，运营，销售，市场推广等各个领域得到大规模的实践。\n" +
                "很多人曾经怀疑LinkedIn的估值过高，实际上华尔街给予LinkedIn 的估值，基于很多非常基础的指标。其中一个重要的公式就是获客成本（CAC）和用户生命周期价值（LTV）之间的关系，LinkedIn获取企业客户的成本远远低于普通的SaaS竞争对手。比如说我们曾经打造的整个销售线索数据系统，客户成功分析系统，市场营销数据分析系统，产品分析系统等等让各个部门做到完全数据分析驱动。这里的直接结果就是，LinkedIn对比普通运营良好的SaaS企业，她的CAC／LTV比值，一般只有竞争对手的一半左右。销售和市场的总cost，比竞争对手或同类型的公司低一倍以上。这就让整个的公司增长在同等资源支持下要快好几倍。" +
                "哈弗曼（LinkedIn创始人&CEO）设计 LinkedIn 战略的时候，他收集大量的用户信息，想了三种变现方式。\n" +
                "第一种，通过用户的基本信息来变现，比如说公司发布职位。\n" +
                "第二种，用户数量增长到一定程度的时候，有 B2B 企业投广告。\n" +
                "第三种，当有大量人的信息以后，公司的猎头会用这个平台来找候选人。\n" +
                "变现的方式他也想得很清楚，但并没有在第一天就去做，他核心关注的是用户体验和使用度，是整体的增长，增长产生大量的数据，他从数据里学习，未来才做变现。\n" +
                "LinkedIn 在只有 1 万用户的时候就开始用数据驱动业务。早期的时候，第一批用户获取就完全靠创始人冷启动，所有的联合创始人和最早期的 10 个员工，每个人需要拉 500 个朋友进来，这就是他获取的第一批 1 万个用户。\n" +
                "之后，招来第一个产品经理，开始做下一轮的增长，从 1 万到 2 万 5 千，这段时间他们去观测两个渠道，一个是电子邮件，一个是搜索：\n" +
                "LinkedIn 刚出来创始团队都有一些光环，所以会有用户主动搜索 LinkedIn 或者搜索人。我们从数据里发现，从 SEO 的渠道里进来的用户，比电子邮件邀请进来的人数量差不多，但在产品平台上的活跃度要高 3 倍。这是之前没有想到过的，于是做了一个决定：如果要获取同样数量的用户，他们更愿意投入资源在使用频次更高、更愿意把时间花在这里的，所以，放弃低活跃的用户，专注活跃的用户。\n" +
                "我认为，这是他的产品战略执行层面里面第一个事情正确做的事情。\n" +
                "创业者应该从什么时候开始关注数据？\n" +
                "Greylock 也是投资人，以前是 Pinterest 的产品经理。当时增长速度非常快，每年他们都是几倍的增长，他总结出来一套框架，在产品整个生命周期里面，创始人在什么时候应该对数据敏感。\n" +
                "在产品最早期，不需要太多数据，凭借创始人的直觉，产品经理的直觉，做决策占很大的比例。但是到后来的话，数据化运营就越来越重要了，一个人在赌场里面不可能永远的赢，一个团队不断变大的话，不可能所有的员工都有直觉决策力，到未来以后数据来驱动决策能保证效率。\n" +
                "数据会告诉你很多信号，这些信号让你有一个标准，可促进增长的空间，你带着假设迅速的验证。我们现在还在持续的优化，今天我们变成 20% 多的转化率了。" +
                "如果全公司只做一件事的话，这件事是什么？\n" +
                "LinkedIn 每年反复要去问的一个问题是：如果只有一件事全公司要做的话，是什么？得用数字来证明的：一星期内加到 5 个联系人的用户，他们的留存／使用频度／停留时间是那些没有加到 5 个联系人的用户的三倍到五倍，这是他们找到的驱动增长的魔法数字。\n" +
                "但是当时这样的人非常非常少，于是他们在产品各个入口都增加社交关系。LinkedIn 还有一个上传地址簿的功能，还给你推荐哪些人你可能认识，同时把这些功能点放在各个产品页面的入口。\n" +
                "LinkedIn 最早的时候并不知道为什么增加社交关系会产生那么大的留存度，我们分析了起码有两三百个各种不同的指标，最后没有任何一个指标能告诉我们，就是因为这个原因。\n" +
                "可是加权以后的结果是这些用户在上面花了很多时间，间接就成为变现的可能。但是产品经理就把非常复杂的问题简化，让所有的东西都关注这一个点：关注这个魔法数字，让更多的用户在第一周里加到5 个联系人。于是，当时增长速度是非常快的。");
        CONTENTS.add("一. 用户行为分析的巨大需求\n" +
                "纯从数据组成的角度来说，一个完善的闭环数据源主要是分成三大块：第一块是用户行为数据，第二块是服务端日志数据，第三块是交易 Transaction 数据。其中，除了交易数据会经常被存储在离线数据库中，通过 ETL 来获取分析以外，行为数据和日志数据很多时候都是近似的，完备的用户行为数据基本能覆盖绝大多数的服务端日志数据，同时里面包含着很多日志数据里面所缺乏的信息。\n" +
                "从技术发展角度来说，最近几年发展最快的可以说是前端，每个月都会有很多新的东西出现，整体趋势是往单页应用发展，追求用户体验。同时，还有移动端应用，也产生着大量的行为数据，这些都不会跟服务端有过多交互。\n" +
                "所以，从应用提供商来说，我们需要知道屏幕前的人是怎么使用我们的产品的，洞悉用户行为背后的价值。\n" +
                "GrowingIO 从去年 12 月 8 号发布到现在已经过去几个月了，目前有几百家客户在使用。我总结了一下客户经常问我们的分析需求，大致可以分成三个场景：\n" +
                "第一个场景是：我做了一次活动，我写了一篇文章，我想知道到底效果如何，有没有给我带来足够的流量，也就是市场营销效果衡量。我们有些客户，每年有上百万的市场预算在 SEM 上，但是却完全不知道这些钱花出去到底带来了多少回报。\n" +
                "第二个场景是用户激活流程是否合理，辛辛苦苦导入了流量，这些流量有没有转化为用户，注册流里面每一步转化了多少，流逝了多少，没有转化的去了哪里。再在这个基础上，我们应该怎么优化，优化后的效果是怎样的，这周的转化率比起上周是否有进步，差别是怎么引起的等等。\n" +
                "第三个场景是这些注册的用户，有没有留下来成为一个忠诚用户甚至付费用户。留下来的用户，是因为什么留下来的。是否存在一个魔法数字，可以去极大的提高用户留存，比如： LinkedIn 发现在第一周增加 5 个社交关系的用户留存度很高； Facebook 发现在第一周增加 10 个好友的用户留存度很高； Twitter 发现在第一周有 30 个 followers 的用户留存度很高； Dropbox 发现在第一周安装两个以上操作系统的用户留存度很高。 这些都是在留存分析中发现的魔法数字。\n" +
                "\n" +
                "二. 复杂而易错的传统分析方法\n" +
                "归根结底，所有的分析最终都是为了商业服务，而商业是为人服务的。所以，用户行为分析就是我们需要建立一套基于用户的行为的分析体系，在了解用户“谁”做了“什么”，“怎么”做的之外，进而明白是“为什么”做，对症下药，转化成为优化行动。\n" +
                "分析是一个长时间优化的过程，需要我们持续监控数据的变化。而数据指标除了行为数据指标外还有一类，我们称之为虚荣指标，比如 PV、UV 之类流量概览性数据，这些指标看到了也就看到了，没法指导我们做的更好。用户行为数据指标则是另外一类，比如我们上面介绍的用户获取、用户激活、用户留存之类，了解这些行为后面都会对应到一个优化流程，所以也叫做 Actionable Metric，可执行指标，这也是用户行为数据的魅力。\n" +
                "用户行为数据分析的基本流程 - 副本.png\n" +
                "那么接下来，我们要开始跟踪用户行为了，我们要怎么开始呢。一般可以分成以下七个步骤：\n" +
                "1.确定分析场景或目标\n" +
                "确定一个场景，或者一个目标。比如，我们发现很多用户访问了注册页面，但是最终完成注册的很少，那么我们的目标就是提高注册转化率，了解为什么用户没有完成注册，是哪一个步骤挡住用户了。\n" +
                "2.思考需要了解哪些数据\n" +
                "思考哪些数据我们需要了解，帮助我们实现这个目标。比如对于之前的目标，我们需要拆解从进入注册页面到完成注册的每一个步骤的数据，每一次输入的数据，同时，完成或者未成为这些步骤的人的特征数据。\n" +
                "3.确定谁来负责收集数据？\n" +
                "谁负责收集这些数据，一般是我们工程师出马。\n" +
                "4.什么时候评估和分析？\n" +
                "收集上来的数据如何分析，什么时候来评估采集到的数据。\n" +
                "5.如何给出优化解决方案？\n" +
                "发现问题后，怎么来出解决方案。比如，是否在设计上改进，或者是否是工程上的 bug。\n" +
                "6.谁负责实现解决方案。确定方案的实施责任人。\n" +
                "7.如何评估解决方案的效果？\n" +
                "下一轮数据采集和分析，回到第一步继续迭代。\n" +
                "知易行难。这整个流程里，第 2 步到第 4 步是关键。目前传统的服务商比如 GA、Mixpanel、友盟所采用的方式我称之为 Capture 模式。通过在客户端埋下确定的点，采集相关数据到云端，最终在云端做呈现。比如图中这个示例，相信在座的各位应该都有写过类似的代码。");
    }

}
